package javase.day2and3;

import java.io.*;
import java.net.Socket;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/8 18:36
 */
public class Clinet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",100);
        //往服务端发消息的流
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //从服务器接受消息的流
        InputStream SinputStream =socket.getInputStream();
        BufferedReader SbufferedReader = new BufferedReader(new InputStreamReader(SinputStream));
        //从文本读取的流
        FileInputStream fileInputStream = new FileInputStream("E://reabc.txt");
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream));

        while(true){
            //发消息
            String s = bufferedReader1.readLine();
            System.out.println("我发送的消息是"+s);
            printWriter.println(s);
            printWriter.flush();
            if(s.equals("exit")) break;
            //接受消息
            s = SbufferedReader.readLine();
            System.out.println("服务端发送的消息是："+s);
            if(s.equals("exit")) break;

        }
        socket.close();
    }
}
