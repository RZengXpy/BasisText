package javase.newday6and7.MulChart.view;

import javase.newday6and7.MulChart.data.Data;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/12 8:07
 */

public class LoginFrame extends Frame {
    //登录界面基础组件
    Label luserName = new Label("用户名：");
    Label luserWord = new Label("密   码：");
    TextField tuserName = new TextField(20);
    TextField tuserWord = new TextField(20);
    Button blogin = new Button("登录");
    Button bempty = new Button("清空");
//    Button bregister = new Button("注册");

    //错误提示框基础组件
    Dialog errorTip = new Dialog(this, "错误信息提示", true);
    Label errorTipLab = new Label();
    Button errorTipOkBut = new Button("确定");
    String info = "您输入错误或该账号已登录，请重新输入！";

    //组件1 是界面上的QQ蓝色面板图像，图像我们把它放在JLabel类对象上
    ImageIcon imageqq = new ImageIcon(this.getClass().getResource("QQ面板.png"));
    JLabel component1 = new JLabel(imageqq);

    //界面字体
    Font font = new Font("Microsoft Uighur", Font.BOLD, 15);

    /**
     * 重写构造方法，对界面布局
     * @throws HeadlessException
     */
    public LoginFrame() throws HeadlessException {
        //查找图像的位置！
//        String s1=this.getClass().getResource("").getPath();
//        String s2=this.getClass().getResource("/").getPath();
//        System.out.println(s1);
//        System.out.println(s2);

        //设置登录界面的大小
        this.setSize(385, 360);
        //使界面居中显示
        this.setLocationRelativeTo(null);
        //界面不可缩放
        this.setResizable(false);
        //界面名字
        this.setTitle("登录界面");

        //账号密码错误提示
        errorTip.setSize(400, 150);
        errorTip.setLayout(new GridLayout(2, 1, 5, 15));
        errorTip.setLocationRelativeTo(null);
        //错误提示界面布局
        Panel labPanel = new Panel();
        labPanel.add(errorTipLab);
        errorTip.add(labPanel);

        Panel okPanel = new Panel();
        okPanel.add(errorTipOkBut);
        errorTip.add(okPanel);

        //设置提示框不可见
        errorTip.setVisible(false);

        //网格布局2行1列，节点水平间距5，垂直间距15
        this.setLayout(new GridLayout(2, 1, 5, 15));

        //qq面板
        Panel image = new Panel();
        image.add(component1);

        //除了qq面板的总面板
        Panel all = new Panel();
        //存放其他组件
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();

        panel1.setSize(100, 200);
        panel1.add(luserName);
        panel1.add(tuserName);
        all.add(panel1);

        tuserWord.setEchoChar('*');
        panel2.add(luserWord);
        panel2.add(tuserWord);
        all.add(panel2);

        panel3.add(blogin);
//        panel3.add(bregister);
        panel3.add(bempty);
        all.add(panel3);

        this.add(image);
        this.add(all);
        this.setFont(font);
        //加载监听事件
        myEvent();
        this.setVisible(true);
    }

    /**
     * 事件监听
     */
    private void myEvent() {
        // 确定按钮监听器
        errorTipOkBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorTip.setVisible(false);
                //先调用，才能清空，正常不用先调用
                tuserName.getText();
                tuserName.setText(null);
                tuserWord.getText();
                tuserWord.setText(null);
            }
        });

        //登录按钮监听器
        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == blogin) {
                    login();
                } else if (e.getSource() == bempty) {
                    //先调用，才能清空，正常不用先调用
                    tuserName.getText();
                    tuserName.setText(null);
                    tuserWord.getText();
                    tuserWord.setText(null);
                }
            }
        });

        //密码框按ENTER键登录
        tuserWord.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)//如果按下回车键执行功能函数
                {
                    login();
                }
            }
        });

        //提示标签的隐藏
        errorTip.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                errorTip.setVisible(false);
            }
        });

        // 窗体关闭监听器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 登录方法
     */
    public void login() {
        String suserName = tuserName.getText();
        String suserWord = tuserWord.getText();
        if (Data.service.loginService(suserName, suserWord)) {
            Data.mf.setFriends(suserName);
            System.out.println(suserName);
            Data.mf.setVisible(true);
            LoginFrame.this.setVisible(false);
        } else {
            //显示文本错误提示信息
            errorTipLab.setText(info);
            //设置对话框可见
            errorTip.setVisible(true);
        }
    }
}

