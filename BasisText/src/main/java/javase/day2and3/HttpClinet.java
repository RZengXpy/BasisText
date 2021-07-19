package javase.day2and3;

import java.io.*;
import java.net.Socket;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/9 10:08
 */
public class HttpClinet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("http://mail.163.com",80);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.println("GET / HTTP/1.1");
        printWriter.println("Host: http://mail.163.com:80");
        printWriter.println("");
        printWriter.flush();

        InputStream inputStream = socket.getInputStream();
        int x;
        while((x=inputStream.read())!=-1){
            System.out.println((char) x);
        }

    }
}
