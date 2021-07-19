package javase.day4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/10 8:27
 */
public class ThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1000);
        Socket socket = serverSocket.accept();
        System.out.println("有人连上了");
        //副线程调用,接受消息
        ServerReciveInfo serverReciveInfo = new ServerReciveInfo();
        serverReciveInfo.setSocket(socket);
        serverReciveInfo.start();

        //主线程发送消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);


        while(true){
            String string = bufferedReader.readLine();
            printWriter.println("Server："+string);
            printWriter.flush();
            if("exit".equals(string)) break;
        }
        outputStream.close();
        socket.close();
    }
}

class ServerReciveInfo extends Thread{
    Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream=socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while(true){
               String string =  bufferedReader.readLine();
                System.out.println(string);
                if(string.equals("exit")) break;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}