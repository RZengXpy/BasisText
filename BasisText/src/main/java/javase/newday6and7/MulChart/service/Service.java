package javase.newday6and7.MulChart.service;

import javase.newday6and7.MulChart.data.Data;
import javase.newday6and7.MulChart.model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/13 16:33
 */
public class Service {
    /**
     * 登录协议核心代码
     *
     * @param username  输入的用户名
     * @param password  输入的密码
     * @return 用户名 && 密码
     */
    public boolean loginService(String username , String password){
        Socket socket = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = new Socket(Data.serverHost, Data.serverPort);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            HashMap<String,String>request = new HashMap<>();
            //登录请求
            request.put("type","loginrequest");
            request.put("username",username);
            request.put("password",password);
            request.put("clientip", Data.clientHost);
            request.put("clientport", Data.clientPort+"");
            objectOutputStream.writeObject(request);

            //登录响应
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            HashMap<String , Object> response = (HashMap<String, Object>) objectInputStream.readObject();
            String state = (String) response.get("state");
            if(state.equals("ok")){
                Data.mySelf = (User) response.get("user");
                Data.Friends = (HashMap<String, User>) response.get("friends");
                return true;
            }else return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(objectOutputStream!=null) {
                try {
                    objectOutputStream.close();
                    if(objectInputStream!=null) objectInputStream.close();
                    if(socket!=null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
