package javase.day2and3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/9 9:51
 */
public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1000);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        int x;
        while((x=inputStream.read())!=-1){
            System.out.println((char) x);
        }
        inputStream.close();
        socket.close();
    }
}
