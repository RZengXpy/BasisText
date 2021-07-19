package javase.day2and3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/8 18:35
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ser = new ServerSocket(100);
        Socket socket = ser.accept();
        System.out.println("服务器已启动,等待连接");
        //从服务器接受消息的流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //往服务端发消息的流
        OutputStream CoutputStream = socket.getOutputStream();
        PrintWriter CprintWriter = new PrintWriter(CoutputStream);
        BufferedReader CbufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //从文本读取的流
        FileInputStream fileInputStream = new FileInputStream("E://abc.txt");
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream));

        System.out.println("有人连上了");
        while (true) {
            //接受消息
            String s = bufferedReader.readLine();
            System.out.println("客户端发送的消息是：" + s);
            if (s.equals("exit")) break;

            //发消息
//            s = CbufferedReader.readLine();
//            CprintWriter.println(s);
//            CprintWriter.flush();
//            if(s.equals("exit")) break;

            //从文本获取，自动回复！
//            String s1 = bufferedReader1.readLine();
//            if(s.equals(s1)) {
//                CprintWriter.println(bufferedReader1.readLine());
//                CprintWriter.flush();
//            }
            String s1 = bufferedReader1.readLine();
            System.out.println("我发送的消息是"+s1);
            CprintWriter.println(s);
            CprintWriter.flush();
        }
        socket.close();
    }
}
