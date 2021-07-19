package javase.day6and7.MulChart.data;

import javase.day6and7.MulChart.model.User;
import javase.day6and7.MulChart.service.Service;
import javase.day6and7.MulChart.view.MainFrame;

import java.util.HashMap;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/13 8:10
 */
public class Data {
    public static MainFrame mf;
    public static HashMap<String, User> Friends = null;
    public static User mySelf = null;
    public static String serverHost = "127.0.0.1";
    public static int serverPort = 11002;
    public static Service service = new Service();
    public static String clientHost = null;
    public static int clientPort = -1;
    public static int StartPort = 10001;
    public static int endPort = 11001;
}
