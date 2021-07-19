//package P2P1;
//
//import day6.MulChart.model.SentCotent;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * @version 1.0
// * @Description: TODO
// * @Author RZeng
// * @date 2021/7/12 10:26
// */
//public class AgentTest {
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ServerSocket serverSocket = new ServerSocket(10002);
//        System.out.println("服务器已启动！");
////        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());;
//        //接受消息，打印到控制台
//        while(true){
//            Socket socket = serverSocket.accept();
//            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//            SentCotent sentCotent = (SentCotent)objectInputStream.readObject();
//            System.out.println(sentCotent.getUsername());
//            System.out.println(sentCotent.getContent());
//            objectInputStream.close();
//            socket.close();
//        }
//    }
//}
