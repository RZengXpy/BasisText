package javase.day6and7.MulChart.Main;


import javase.day6and7.MulChart.data.Data;
import javase.day6and7.MulChart.view.LoginFrame;
import javase.day6and7.MulChart.view.MainFrame;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/12 8:06
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        for (int port = Data.StartPort; port < Data.endPort; port++) {
//            if (portIsIdeal(port)){
//                Data.clientPort = port;
//                System.out.println("可用端口号为："+port);
//                break;
//            }
//        }
//        InetAddress inetAddress = InetAddress.getLocalHost();
//        Data.clientHost = inetAddress.getHostAddress();

        LoginFrame loginFrame = new LoginFrame();
        Data.mf = new MainFrame();
//        while (Data.mySelf. == null) ;
//        //while(Data.mySelf==null){System.out.println(sda);}

        Data.mf.Recive();
    }

//    public static boolean portIsIdeal(int port) {
//        Socket socket = null;
//        try {
//            socket = new Socket("127.0.0.1", port);
//            return false;
//        } catch (Exception e) {
//            return true;
//        } finally {
//            try {
//                if (socket != null)
//                    socket.close();
//                } catch(IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
    }
