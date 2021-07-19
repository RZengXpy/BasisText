//package P2P1;
//
//import javafx.scene.layout.VBox;
//
//import java.awt.*;
//import java.awt.event.*;
//
///**
// * @version 1.0
// * @Description: TODO
// * @Author RZeng
// * @date 2021/7/12 8:07
// */
//public class LoginFrame extends Frame {
//    //登录界面布局
//    Label luserName = new Label("用户名：");
//    Label luserWord = new Label("密  码：");
//    TextField tuserName = new TextField(20);
//    TextField tuserWord = new TextField(20);
//    Button blogin = new Button("登录");
//    Button bcancel = new Button("清空");
//    //输入错误使布局
//    Dialog errorTip = new Dialog(this, "错误信息提示", true);
//    Label lab = new Label();
//    Button okBut = new Button("确定");
//
//    public LoginFrame() throws HeadlessException {
//        this.setBounds(760, 300, 300, 200);
//        this.setTitle("登录界面");
//
//        //对话框弹出
//        errorTip.setBounds(760, 400, 350, 150);
//        errorTip.setLayout(new GridLayout(2, 1, 5, 15));
//        //创建lab标签填写提示内容
//        Panel labPanel = new Panel();
//        labPanel.add(lab);
//        errorTip.add(labPanel);
//
//        Panel okPanel = new Panel();
//        okPanel.add(okBut);
//        errorTip.add(okPanel);
//
//        errorTip.setVisible(false);
//
//        //网格布局，3行1列间距15
//        this.setLayout(new GridLayout(3, 1, 15, 15));
//        Panel panel1 = new Panel();
//        Panel panel2 = new Panel();
//        Panel panel3 = new Panel();
//
//        panel1.add(luserName);
//        panel1.add(tuserName);
//        this.add(panel1);
//
//        tuserWord.setEchoChar('*');
//        panel2.add(luserWord);
//        panel2.add(tuserWord);
//        this.add(panel2);
//
//        blogin.addActionListener(new LoginListener());
//        panel3.add(blogin);
//        panel3.add(bcancel);
//        this.add(panel3);
//        myEvent();
//        //添加 关闭按钮 监听器
////        this.addWindowListener(new WindowEventListener());
//        this.setVisible(true);
//    }
//
//    private void myEvent() {
//        // 确定按钮监听器
//        okBut.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                errorTip.setVisible(false);
//                //先调用，才能清空，正常不用先调用
//                tuserName.getText();
//                tuserName.setText(null);
//                tuserWord.getText();
//                tuserWord.setText(null);
//            }
//        });
//
////        okBut.addKeyListener(new KeyAdapter() {
////            public void KeyPressed(KeyEvent e){
////                if (e.getKeyCode() == KeyEvent.VK_ENTER)//如果按下回车键执行功能函数{
////                    errorTip.setVisible(false);
////                //先调用，才能清空，正常不用先调用
////                tuserName.getText();
////                tuserName.setText(null);
////                tuserWord.getText();
////                tuserWord.setText(null);
////            }
////        });
//
//        //文本框兼容器
//        tuserWord.addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER)//如果按下回车键执行功能函数
//                    login();
//            }
//        });
//        //登录按钮触发器
//        // 窗体关闭监听器
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//
//            }
//
//        });
//    }
//
//    class LoginListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == blogin) {
//                login();
//            } else if (e.getSource() == bcancel) {
//                //先调用，才能清空，正常不用先调用
//                tuserName.getText();
//                tuserName.setText(null);
//                tuserWord.getText();
//                tuserWord.setText(null);
//            }
//        }
//    }
//
//    public void login() {
//        String suserName = tuserName.getText();
//        String suserWord = tuserWord.getText();
//        if ("admin".equals(suserName) && "admin".equals(suserWord)) {
//            LoginFrame.this.setVisible(false);
//            Data.mf.setVisible(true);
//        } else {
//            String info = "您输入的账号或者密码是错误的，请重新输入！";
//            //显示文本错误提示信息
//            lab.setText(info);
//            //设置对话框可见
//            errorTip.setVisible(true);
//        }
//    }
//}
//
//class Data {
//    public static MainFrame mf = new MainFrame();
//}
