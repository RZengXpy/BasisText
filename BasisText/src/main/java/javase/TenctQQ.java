package javase; /**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/15 21:32
 */

import javax.swing.*;
import java.awt.*;

public class TenctQQ {
    public static void main(String args[]) {
        TenctQQ ui = new TenctQQ();
        ui.show();
    }

    public void show() {
        /*
         * 窗体的基本设置
         */
        Frame jf = new Frame();
        jf.setSize(385, 345);
        jf.setLocationRelativeTo(null);
//        jf.setDefaultCloseOperation(3);
        jf.setResizable(true);
        /*
         * 生成窗体中的各种组件
         */
        ImageIcon imageQQ = new ImageIcon(this.getClass().getResource("QQ面板.png"));
        JLabel component1 = new JLabel(imageQQ);
        //组件1 是界面上的QQ蓝色面板图像，图像我们把它放在JLabel类对象上
        ImageIcon imageqq = new ImageIcon(this.getClass().getResource("QQ头像.png"));
        JLabel component2 = new JLabel(imageqq);
        //组件2 是界面上的QQ企鹅图像，同理图像我们把它放在JLabel类对象上
        TextField component3 = new TextField();
        //组件3是用户的账号输入框
        JLabel component4 = new JLabel("用户账号");
        //组件4是用户的账号输入框右边的提示标签
        TextField component5 = new TextField();
        //组件5是用户的密码输入框
        JLabel component6 = new JLabel("用户密码");
//        //组件6是用户的密码输入框右边的提示标签
//        JCheckBox component7 = new JCheckBox("记住密码");
//        //组件7是用户的“记住密码”的勾选键
//        JCheckBox component8 = new JCheckBox("自动登录");
//        //组件8是用户的“自动登录”的勾选键
        JButton component7 = new JButton("登录");
        JButton component8 = new JButton("注册");
        //组件8是用户的“安全登录”的按键
//        JFrame show = new JFrame("展示");
//        show.setSize(600, 600);
//        show.setLocation(200, 50);
//        //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
//        String path = "src/Q头像.png";
//        System.out.println(this.getClass().getResource("Q面板.png"));
//        String s1=this.getClass().getResource("").getPath();
//        String s2=this.getClass().getResource("/").getPath();
//        System.out.println(s1);
//        System.out.println(s2);
//        ImageIcon background = new ImageIcon(this.getClass().getResource("QQ面板.png"));
//        // 把背景图片显示在一个标签里面
//        JLabel label = new JLabel(background);
//        // 把标签的大小位置设置为图片刚好填充整个面板
//        label.setBounds(0, 0, show.getWidth(), show.getHeight());
//        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
//        JPanel imagePanel = (JPanel) show.getContentPane();
//        imagePanel.setOpaque(false);
//        // 把背景图片添加到分层窗格的最底层作为背景
//        show.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//        show.setVisible(true);
//        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * 对窗体进行布局
         */
        GridBagLayout gridBagLayout = new GridBagLayout(); //实例化布局对象
        jf.setLayout(gridBagLayout);                     //jf窗体对象设置为GridBagLayout布局
        GridBagConstraints gridBagConstraints = new GridBagConstraints();//实例化这个对象用来对组件进行管理
        gridBagConstraints.fill = GridBagConstraints.BOTH;//该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
        //NONE：不调整组件大小。
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
        //VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
        //BOTH：使组件完全填满其显示区域。
        /*
         * 分别对组件进行设置
         */
        //组件1(gridx,gridy)组件的左上角坐标，gridwidth，gridheight：组件占用的网格行数和列数
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagLayout.setConstraints(component1, gridBagConstraints);
        //组件2
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 4;
        gridBagLayout.setConstraints(component2, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(component3, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(component4, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(component5, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(component6, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(component7, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(component8, gridBagConstraints);

//        gridBagConstraints.gridx = 1;
//        gridBagConstraints.gridy = 7;
//        gridBagConstraints.gridwidth = 2;
//        gridBagConstraints.gridheight = 1;
//        gridBagLayout.setConstraints(component9, gridBagConstraints);
        /*
         * 把所有组件加入jf窗体对象中去
         */
        jf.add(component1);
        jf.add(component2);
        jf.add(component3);
        jf.add(component4);
        jf.add(component5);
        jf.add(component6);
        jf.add(component7);
        jf.add(component8);
//        jf.add(component9);
        jf.setVisible(true);
    }
}

