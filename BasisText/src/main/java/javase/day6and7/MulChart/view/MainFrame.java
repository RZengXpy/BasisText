package javase.day6and7.MulChart.view;

import javase.day6and7.MulChart.data.Data;
import javase.day6and7.MulChart.model.SentCotent;
import javase.day6and7.MulChart.model.User;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/12 8:06
 */
public class MainFrame extends Frame {
    TextArea sentBox = new TextArea(3, 10);
    TextArea reciveBox = new TextArea(10, 10);
    Button bSent = new Button("发送");
    List offLinefriendList = new List(10);
    List onLinefriendList = new List(10);

    User taleToUser = null;
    //界面字体
    Font font = new Font("Microsoft Uighur", Font.ITALIC, 20);

    public MainFrame() {

        this.setBounds(760, 300, 500, 500);
        this.setResizable(false);
        //文本编辑区
        sentBox.setFont(font);
        this.add(sentBox, BorderLayout.NORTH);
        //聊天记录区
        //文本不可编辑，设为false
        reciveBox.setEditable(false);
        reciveBox.setBackground(Color.white);
        reciveBox.setFont(font);
        this.add(reciveBox, BorderLayout.CENTER);
        this.add(bSent, BorderLayout.SOUTH);
        this.add(onLinefriendList, BorderLayout.EAST);
        //离线先不处理
        offLinefriendList.setEnabled(false);
        this.add(offLinefriendList, BorderLayout.WEST);
        this.setFont(font);
        myEvent();
        this.setVisible(false);
    }

    //事件监听
    private void myEvent() {
        //聊天监听器,将消息显示到聊天记录框并发送过去
        //ctrl+Enter,发送消息
        sentBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
                    EnterMessange();
                }
            }
        });
        //点击发送按钮，发送消息
        bSent.addActionListener(new ActionListener() {
            //actionPerformed()自动创建线程完成
            @Override
            public void actionPerformed(ActionEvent e) {
                EnterMessange();
            }
        });
        // 窗体关闭监听器
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Socket socket = null;
                try {
                    socket = new Socket(Data.serverHost, Data.serverPort);
                    ObjectOutputStream objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
                    HashMap<String,String> request = new HashMap<>();
                    request.put("type","offlinerequest");
                    request.put("username", Data.mySelf.getUsername());
                    objectOutputStream.writeObject(request);

                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    HashMap<String,Object> response = (HashMap<String, Object>) objectInputStream.readObject();
                    String state = (String) response.get("state");
                    if(state.equals("ok")){
                        System.exit(0);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } finally {
                    try {
                        if(socket!=null) socket.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }

    //接受消息，端口号11000
    public void Recive() {
        try {
            ServerSocket serverSocket = new ServerSocket(0);
            Data.clientPort = serverSocket.getLocalPort();
            InetAddress inetAddress = InetAddress.getLocalHost();
            Data.clientHost = inetAddress.getHostAddress();
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                Object object = objectInputStream.readObject();
                if (object instanceof HashMap) {
                    HashMap<String, Object> map = (HashMap<String, Object>) object;
                    //将上线好友放入user
                    User user = (User) map.get("onlineuser");
//                    //将好友列表找到
//                    User user1 = Data.Friends.get(user.getUsername());
//                    user1.setOnline(true);
                    Data.Friends.put(user.getUsername(), user);

                    offLinefriendList.removeAll();
                    onLinefriendList.removeAll();
                    setFriends();
                    continue;
                }

                SentCotent sentCotent = (SentCotent) object;

                String username = sentCotent.getUsername();
                String content = sentCotent.getContent();

                User user = Data.Friends.get(username);
                String petName = user.getPetName();

                user.setHistoricRecord(user.getHistoricRecord() + petName + ":\n" + content + "\n\n");

                objectInputStream.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFriends() {

        //好友列表
        Set<String> frendsNameSet = Data.Friends.keySet();
        for (String str : frendsNameSet) {
            User user = Data.Friends.get(str);
            System.out.println(user);
            if (user.isOnline()) onLinefriendList.add(user.getUsername() + "-" + user.getPetName());
            else offLinefriendList.add(user.getUsername() + "-" + user.getPetName());
        }
        onLinefriendList.addItemListener(new MainFrame.ListListener());
        offLinefriendList.addItemListener(new MainFrame.ListListener());
        this.setTitle("简易聊天——当前用户为：" + Data.mySelf.getPetName());
    }

    //内部类
    class ListListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String string = onLinefriendList.getSelectedItem();
            //取得账号，split方法分割字符串，存在数组里面！
            String selectUsername = string.split("-")[0];
            //由账号取得用户的所有信息
            User user = Data.Friends.get(selectUsername);
            taleToUser = user;
            //当换好友时，更改聊天记录
            reciveBox.setText(taleToUser.getHistoricRecord());

        }
    }

    public void EnterMessange() {
        //联网测试——将发送内容发送到对方
        try {
            String sentString = sentBox.getText();
//                reciveBox.append("Me:\n" + sentString + "\n\n");
            Socket socket = new Socket(taleToUser.getHost(), taleToUser.getPort());
            SentCotent sentCotent = new SentCotent(Data.mySelf.getUsername(), sentString);
            //往服务端发消息
//                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                dataOutputStream.writeUTF(sentString);
//                dataOutputStream.flush();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(sentCotent);
            objectOutputStream.flush();
            //清空消息
            sentBox.setText("");
            //将发送内容显示到聊天框
            taleToUser.setHistoricRecord(taleToUser.getHistoricRecord() + Data.mySelf.getPetName() + ":\n" + sentString + "\n\n");
            reciveBox.setText(taleToUser.getHistoricRecord());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}