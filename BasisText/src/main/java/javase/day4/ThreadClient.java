package javase.day4;

import java.io.*;
import java.net.Socket;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/10 8:27
 */
public class ThreadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",1000);
        //线程调用
        ClientReciveInfo clientReciveInfo = new ClientReciveInfo();
        clientReciveInfo.setSocket(socket);
        clientReciveInfo.start();
        //发送消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);


        while(true){
            String string = bufferedReader.readLine();
            printWriter.println("Client:"+string);
            printWriter.flush();
            if("exit".equals(string)) break;
        }
        outputStream.close();
        clientReciveInfo.
        socket.close();
    }
}
class ClientReciveInfo extends Thread{
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