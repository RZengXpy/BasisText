package javase.newday6and7.MulChart.Main;


import javase.newday6and7.MulChart.data.Data;
import javase.newday6and7.MulChart.view.LoginFrame;
import javase.newday6and7.MulChart.view.MainFrame;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/12 8:06
 */
public class Main {
    public static void main(String[] args) throws Exception {
        LoginFrame loginFrame = new LoginFrame();
        Data.mf = new MainFrame();
        Data.mf.recive();
    }
}
