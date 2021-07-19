package javase.newday6and7.Server.main;

import javase.newday6and7.Server.data.Data;
import javase.newday6and7.MulChart.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/13 16:10
 */
public class ServerMain {
    /**
     * 服务器
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //启动模拟数据库
        database();
        
        //服务器
        ServerSocket serverSocket = new ServerSocket(11002);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            HashMap<String, Object> request = (HashMap<String, Object>) objectInputStream.readObject();

            HashMap<String, Object> response = new HashMap<>();
            String type = (String) request.get("type");
            //如果协议信息正确，将request交给处理登录的方法或下线方法
            if (type.equals("loginrequest")) {
                serverLogin(request, response);
            }else if(type.equals("offlinerequest")){
                serverOffLine(request, response);
            }

            //response写回
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(response);
            //输出输入流的关闭
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        }
    }

    /**
     * 模拟数据库
     */
    private static void database(){
        //模拟数据库
        Data.loginInfo.put("cr", "123");
        Data.loginInfo.put("flash", "123");
        Data.loginInfo.put("hw", "123");
        Data.loginInfo.put("nx", "123");
        Data.loginInfo.put("bfx", "123");
        User user = new User("cr", "超人", "", -1, "", false);
        Data.users.put(user.getUsername(), user);
        user = new User("flash", "闪电侠", "", -1, "", false);
        Data.users.put(user.getUsername(), user);
        user= new User("hw", "海王", "", -1, "", false);
        Data.users.put(user.getUsername(), user);
        user = new User("nx", "正义女侠", "", -1, "", false);
        Data.users.put(user.getUsername(), user);
        user = new User("bfx", "蝙蝠侠", "", -1, "", false);
        Data.users.put(user.getUsername(), user);
    }

    /**
     * 登录请求协议
     *
     * @param request HashMap<String,String>
     * @param response
     */
    public static void serverLogin(HashMap<String, Object> request, HashMap<String, Object> response) {
        String state = "fail";
        //好友列表和登录者
        User user = new User();
        HashMap<String, User> friends = new HashMap<>();
        //包装
        response.put("type", "loginresponse");

        String username = (String) request.get("username");
        String password = (String) request.get("password");

        if (username == null || password == null) {
            response.put("state", state);
//            response.put("user", user);
//            response.put("friends", friends);
            return;
        }
        //通过账号找密码
        String realPassword = Data.loginInfo.get(username);
        if (realPassword == null) {
            response.put("state", state);
//            response.put("user", user);
//            response.put("friends", friends);
            return;
        }
        if (!realPassword.equals(password)) {
            response.put("state", state);
//            response.put("user", user);
//            response.put("friends", friends);
            return;
        }
        //获取用户名
        user = (User) Data.users.get(username);
        if(user.isOnline()) {
            response.put("state", state);
//            response.put("user", user);
//            response.put("friends", friends);
            return;
        }
        state = "ok";
        response.put("state", state);
        //更改IP地址和端口号
        user.setHost((String)request.get("clientip"));
        user.setPort(Integer.parseInt((String) request.get("clientport")));

        user.setOnline(true);
        //更新好友列表
        Set<String> userNames = Data.users.keySet();
        for (String str : userNames) {
            if (!str.equals(username)) {
                User friend = (User) Data.users.get(str);
                friends.put(friend.getUsername(), friend);
            }
        }
        response.put("user", user);
        response.put("friends", friends);

        notify(user);
    }

    /**
     * 上、下线通知
     *
     * @param currentUser
     */
    public static void notify(User currentUser) {
        Set<String> userNames = Data.users.keySet();
        for (String username : userNames) {
            User serverUser = (User) Data.users.get(username);
            //用户在线，并且不是当前用户
            if (serverUser.isOnline() && !serverUser.getUsername().equals(currentUser.getUsername())) {
                notify(currentUser, serverUser);
            }
        }
    }

    /**
     *将当前用户上下线告诉其他在线用户
     *
     * @param currentUser
     * @param serverUser
     */
    public static void notify(User currentUser, User serverUser) {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = new Socket(serverUser.getHost(), serverUser.getPort());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            HashMap<String, Object> response = new HashMap<>();
            response.put("type", "userOnline");
            response.put("onlineuser", currentUser);
            System.out.println("当前登录或退出用户信息的哈希："+response);

            objectOutputStream.writeObject(response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 好友下线响应协议
     *
     * @param request HashMap<String,User>
     * @param response
     */
    public static void serverOffLine(HashMap<String, Object> request, HashMap<String, Object> response){
        User offUser = (User) request.get("user");
        User user = (User) Data.users.get(offUser.getUsername());
        user.setOnline(false);
        user.setHistoricRecord(offUser.getHistoricRecord());
        notify(user);
        response.put("type","offlineresponse");
        response.put("state","ok");
    }
}
