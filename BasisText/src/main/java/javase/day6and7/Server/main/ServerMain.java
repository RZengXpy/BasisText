package javase.day6and7.Server.main;

import javase.day6and7.MulChart.model.User;
import javase.day6and7.Server.data.Data;

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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //模拟数据库
        Data.loginInfo.put("cr", "123");
        Data.loginInfo.put("flash", "123");
        Data.loginInfo.put("hw", "123");
        Data.loginInfo.put("nx", "123");
        Data.loginInfo.put("bfx", "123");
        User user = new User("cr", "超人", "", -1, "", false);
        Data.users.put(user.getUsername(), user);
        User user1 = new User("flash", "闪电侠", "", -1, "", false);
        Data.users.put(user1.getUsername(), user1);
        User user2 = new User("hw", "海王", "", -1, "", false);
        Data.users.put(user2.getUsername(), user2);
        User user3 = new User("nx", "正义女侠", "", -1, "", false);
        Data.users.put(user3.getUsername(), user3);
        User user4 = new User("bfx", "蝙蝠侠", "", -1, "", false);
        Data.users.put(user4.getUsername(), user4);

        //服务器
        ServerSocket serverSocket = new ServerSocket(11002);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            HashMap<String, String> request = (HashMap<String, String>) objectInputStream.readObject();
            HashMap<String, Object> response = new HashMap<>();
            String type = request.get("type");
            //如果协议信息正确，将request交给处理登录的方法
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

    //登录信息判断
    public static void serverLogin(HashMap<String, String> request, HashMap<String, Object> response) {
        String state = "fail";
        //好友列表和登录者
        User user = new User();
        HashMap<String, User> friends = new HashMap<>();
        //包装
        response.put("type", "loginresponse");

        String username = request.get("username");
        String password = request.get("password");
        if (username == null || password == null) {
            response.put("state", state);
            response.put("user", user);
            response.put("friends", friends);
            return;
        }
        //通过账号找密码
        String realPassword = Data.loginInfo.get(username);
        if (realPassword == null) {
            response.put("state", state);
            response.put("user", user);
            response.put("friends", friends);
            return;
        }
        if (!realPassword.equals(password)) {
            response.put("state", state);
            response.put("user", user);
            response.put("friends", friends);
            return;
        }
        state = "ok";
        response.put("state", state);
        //获取用户名
        user = (User) Data.users.get(username);
        //更改IP地址和端口号
        user.setHost(request.get("clientip"));
        user.setPort(Integer.parseInt(request.get("clientport")));

        user.setOnline(true);
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

    //除了自己以后，通知所有在线用户
    public static void notify(User user) {
        Set<String> userNames = Data.users.keySet();
        for (String username : userNames) {
            User user1 = (User) Data.users.get(username);
            if (user1.isOnline() && !user1.getUsername().equals(user.getUsername())) {
                notify(user, user1);
            }
        }
    }

    //将user给user1，通知给其他人
    public static void notify(User user, User user1) {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = new Socket(user1.getHost(), user1.getPort());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            HashMap<String, Object> map = new HashMap<>();
            map.put("type", "userOnline");
            map.put("onlineuser", user);
            System.out.println("当前登录或退出用户信息的哈希："+map);
            objectOutputStream.writeObject(map);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (objectOutputStream != null) objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //下线消息判断
    public static void serverOffLine(HashMap<String, String> request, HashMap<String, Object> response){
        String offUsername = request.get("username");
        User user = (User) Data.users.get(offUsername);
        user.setOnline(false);
        notify(user);
        response.put("type","offlineresponse");
        response.put("state","ok");
    }
}
