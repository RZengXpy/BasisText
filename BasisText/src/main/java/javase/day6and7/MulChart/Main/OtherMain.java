package javase.day6and7.MulChart.Main;

import javase.day6and7.MulChart.data.Data;
import javase.day6and7.MulChart.view.LoginFrame;
import javase.day6and7.MulChart.view.MainFrame;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/14 10:13
 */
public class OtherMain {
    public static void main(String[] args) throws Exception {
        LoginFrame loginFrame = new LoginFrame();
        Data.mf = new MainFrame();
        Data.mf.Recive();
    }
}
