package javase.newday6and7.MulChart.data;

import javase.newday6and7.MulChart.service.Service;
import javase.newday6and7.MulChart.view.MainFrame;
import javase.newday6and7.MulChart.model.User;

import java.util.HashMap;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/13 8:10
 */
public class Data {
    /**
     * 聊天界面
     */
    public static MainFrame mf;
    /**
     * 存放服务端发过来的好友信息
     */
    public static HashMap<String, User> Friends = null;
    /**
     * 存放自己的消息
     */
    public static User mySelf = null;
    /**
     * 服务器的IP地址，不应该这样做，测试才这样
     */
    public static String serverHost = "127.0.0.1";
    /**
     * 服务器端口号
     */
    public static int serverPort = 11002;
    /**
     * 客户端IP地址
     */
    public static String clientHost = null;
    /**
     * 客户端端口号，由操作系统自动分配
     */
    public static int clientPort = -1;
    /**
     * 方便登录协议的调用
     */
    public static Service service = new Service();
}
