//package P2P2;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// * @version 1.0
// * @Description: TODO
// * @Author RZeng
// * @date 2021/7/12 8:07
// */
//public class LoginFrame extends Frame {
//    Label luserName = new Label("用户名：");
//    Label luserWord = new Label("密  码：");
//    TextField tuserName = new TextField(20);
//    TextField tuserWord = new TextField(20);
//    Button blogin = new Button("登录");
//    Button bcancel = new Button("清空");
//
//    public LoginFrame() throws HeadlessException{
//        this.setBounds(760,300,300,200);
//        this.setTitle("登录界面");
//
//        Dialog errorTip = new Dialog( this,"错误信息提示", true);
//        setBounds(400, 200, 350, 150);
//        errorTip.setLayout(new FlowLayout());
//        //创建lab标签填写提示内容
//        Label lab = new Label();
//        Button okBut = new Button("确定");
//
//        //网格布局，3行1列间距15
//        this.setLayout(new GridLayout(3,1,15,15));
//        Panel panel1 =new Panel();
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
//        bcancel.addActionListener(new LoginListener());
//        panel3.add(blogin);
//        panel3.add(bcancel);
//        this.add(panel3);
//        //添加 关闭按钮 监听器
//        this.addWindowListener(new WindowEventListener());
//        this.setVisible(true);
//    }
//
//    class LoginListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String suserName = tuserName.getText();
//            String suserWord = tuserWord.getText();
//            if(e.getSource() == blogin ){
//                if("admin".equals(suserName)&&"admin".equals(suserWord)){
//                    LoginFrame.this.setVisible(false);
//                    Data.mf.setVisible(true);
//                }else{
//
//                }
//            } else if(e.getSource() == bcancel){
//                //先调用，才能清空，正常不用先调用
//                tuserName.getText();
//                tuserName.setText(null);
//                tuserWord.getText();
//                tuserWord.setText(null);
//            }
//        }
//    }
//}
//
//class Data{
//    public static MainFrame mf = new MainFrame();
//}