package javase.day6and7.MulChart.service;

import javase.day6and7.MulChart.data.Data;
import javase.day6and7.MulChart.model.User;

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
    public boolean loginService(String username , String password){
        Socket socket = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = new Socket(Data.serverHost,Data.serverPort);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            HashMap<String,String>request = new HashMap<>();
            request.put("type","loginrequest");
            request.put("username",username);
            request.put("password",password);
            request.put("clientip",Data.clientHost);
            request.put("clientport",Data.clientPort+"");
            objectOutputStream.writeObject(request);

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
