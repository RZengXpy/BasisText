//package P2P1;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * @version 1.0
// * @Description: TODO
// * @Author RZeng
// * @date 2021/7/12 8:06
// */
//public class MainFrame extends Frame {
//    TextArea sentBox = new TextArea(3, 10);
//    TextArea reciveBox = new TextArea(10, 10);
//    Button bSent = new Button("发送");
//
//    public MainFrame(){
//        Font font = new Font("Microsoft Uighur", Font.ITALIC, 20);
//
//        this.setBounds(760, 300, 500, 500);
//
//        //文本编辑区
//        sentBox.setFont(font);
//        this.add(sentBox, BorderLayout.NORTH);
//
//        //聊天记录查看
//        //文本不可编辑，设为false
//        reciveBox.setEditable(false);
//        reciveBox.setBackground(Color.white);
//        reciveBox.setFont(font);
//        this.add(reciveBox, BorderLayout.CENTER);
//
//        //发送按钮
//        bSent.addActionListener(new MainLinstener());
//        this.add(bSent, BorderLayout.SOUTH);
//
//        this.setTitle("简易P2P聊天");
//        this.addWindowListener(new WindowEventListener());
//        this.setVisible(false);
//    }
//
//    //接受消息，端口号10001
//    public void Recive() {
//        try{
//        ServerSocket serverSocket = new ServerSocket(10001);
//        while (true) {
//            Socket socket = serverSocket.accept();
//            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//            String string = dataInputStream.readUTF();
//            reciveBox.append("Me1:\n" + string + "\n\n");
//            dataInputStream.close();
//            socket.close();
//        }}catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    //聊天监听器,将消息显示到聊天记录框并发送过去
//    class MainLinstener implements ActionListener {
//        //actionPerformed()自动创建线程完成
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            //将发送内容显示到聊天框
//            String sentString = sentBox.getText();
//            reciveBox.append("Me:\n" + sentString + "\n\n");
//            //联网测试——将发送内容发送到对方
//            try {
//                Socket socket = new Socket("127.0.0.1", 10002);
//                //往服务端发消息
//                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                dataOutputStream.writeUTF(sentString);
//                dataOutputStream.flush();
//                //清空消息
//                sentBox.setText("");
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//
//        }
//
//    }
//}
