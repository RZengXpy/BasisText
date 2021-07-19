package javase.newday6and7.MulChart.view;

import javase.newday6and7.MulChart.model.SentCotent;
import javase.newday6and7.MulChart.data.Data;
import javase.newday6and7.MulChart.model.User;

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
    //聊天界面基础组件
    //聊天记录区基本组件
    TextArea sentBox = new TextArea(4, 40);
    TextArea reciveBox = new TextArea(11, 40);
    Button bsent = new Button("发送");
    Button bquit = new Button("退出");
    Button bempty = new Button("清空");
    //好友列表基本组件
    List offLinefriendList = new List(8);
    List onLinefriendList = new List(8);
    User taleToUser = null;
    //退出提示框基础组件
    Dialog quitTip = new Dialog(this, "退出信息提示", true);
    Label quitTipLab = new Label();
    Button quitTipOkBut = new Button("确定");
    String info = "您确认要安全退出吗？";
    //界面字体
    Font font = new Font("Microsoft Uighur", Font.ITALIC, 20);
    //未读消息
    String unread = "";

    /**
     * 重写构造方法
     */
    public MainFrame() {
        //界面大小
        this.setSize(700, 500);
        //界面居中
        this.setLocationRelativeTo(null);
        //界面不可拖动
        this.setResizable(false);
        //界面字体
        this.setFont(font);

        //退出提示
        quitTip.setSize(400, 150);
        quitTip.setLayout(new GridLayout(2, 1, 5, 15));
        quitTip.setLocationRelativeTo(null);
        //退出提示界面布局
        Panel labPanel = new Panel();
        labPanel.add(quitTipLab);
        quitTip.add(labPanel);

        Panel okPanel = new Panel();
        okPanel.add(quitTipOkBut);
        quitTip.add(okPanel);

        //设置提示框不可见
        quitTip.setVisible(false);

        //聊天记录区
        Panel textPanel = new Panel();
        //文本不可编辑，设为false
        reciveBox.setEditable(false);
        textPanel.setLayout(new FlowLayout());
        textPanel.add(reciveBox);
        textPanel.add(sentBox);
        textPanel.add(bsent);
        textPanel.add(bempty);
        textPanel.add(bquit);

        //离线先不处理，不可编辑
        offLinefriendList.setEnabled(false);

        //好友列表具体布局
        Panel onLinePanel = new Panel();
        Panel offLinePanel = new Panel();
        Panel frends = new Panel();

        frends.setLayout(new GridLayout(2, 1));
        onLinePanel.add(onLinefriendList);
        offLinePanel.add(offLinefriendList);
        frends.add(onLinePanel);
        frends.add(offLinePanel);


        this.add(frends, BorderLayout.WEST);
        this.add(textPanel, BorderLayout.CENTER);

        //加载监听事件
        myEvent();
    }

    /**
     * 事件监听
     */
    private void myEvent() {
        //聊天监听器,将消息显示到聊天记录框并发送过去，ctrl+Enter,发送消息
        sentBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
                    enterMessange();
                }
            }
        });

        //发送按钮监听器，发送消息
        bsent.addActionListener(new ActionListener() {
            //actionPerformed()自动创建线程完成
            @Override
            public void actionPerformed(ActionEvent e) {
                enterMessange();
            }
        });

        //清空按钮，清空发送消息；
        bempty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sentBox.getText();
                sentBox.setText("");
            }
        });

        //退出信息提示框
        quitTipOkBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });
        quitTip.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                quitTip.setVisible(false);
            }
        });

        //退出按钮，实现退出
        bquit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示退出提示信息
                quitTipLab.setText(info);
                //设置对话框可见
                quitTip.setVisible(true);
            }
        });

        // 窗体关闭监听器，实现下线通知
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //显示退出提示信息
                quitTipLab.setText(info);
                //设置对话框可见
                quitTip.setVisible(true);
            }
        });
    }

    /**
     * 安全退出
     */
    public void quit() {
        Socket socket = null;
        try {
            socket = new Socket(Data.serverHost, Data.serverPort);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            HashMap<String, Object> request = new HashMap<>();
            request.put("type", "offlinerequest");
            request.put("user", Data.mySelf);
            objectOutputStream.writeObject(request);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            HashMap<String, Object> response = (HashMap<String, Object>) objectInputStream.readObject();
            String state = (String) response.get("state");
            if (state.equals("ok")) {
                System.exit(0);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * 接受好友消息和服务器的消息
     */
    public void recive() {
        try {
            ServerSocket serverSocket = new ServerSocket(0);
            Data.clientPort = serverSocket.getLocalPort();
            InetAddress inetAddress = InetAddress.getLocalHost();
            Data.clientHost = inetAddress.getHostAddress();
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object object = objectInputStream.readObject();
                //如果是协议
                if (object instanceof HashMap) {
                    HashMap<String, Object> map = (HashMap<String, Object>) object;
                    //将上线好友放入user
                    User user = (User) map.get("onlineuser");
                    Data.Friends.put(user.getUsername(), user);
                    //更新好友列表
                    setFriends(Data.mySelf.getUsername());
                    continue;
                }
                //如果是好友发送的消息
                SentCotent sentCotent = (SentCotent) object;
                String username = sentCotent.getUsername();
                String content = sentCotent.getContent();

                User user = Data.Friends.get(username);
                String petName = user.getPetName();
                user.setHistoricRecord(user.getHistoricRecord() + petName + ":\n" + content + "\n\n");
                unread = "-有未读消息！";
                setFriends(user.getUsername());

                objectInputStream.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将消息发送给对方
     */
    public void enterMessange() {
        try {
            //将发送内容发送到对方
            String sentString = sentBox.getText();
            Socket socket = new Socket(taleToUser.getHost(), taleToUser.getPort());
            SentCotent sentCotent = new SentCotent(Data.mySelf.getUsername(), sentString);
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

    /**
     * 上下线获取好友列表及未读消息
     */
    public void setFriends(String username) {
        offLinefriendList.removeAll();
        onLinefriendList.removeAll();
        //好友列表
        Set<String> frendsNameSet = Data.Friends.keySet();
        for (String str : frendsNameSet) {
            User user = Data.Friends.get(str);
            if (user.isOnline()) {
                //未读消息设置
                if (!user.getUsername().equals(username)) {
                    onLinefriendList.add(user.getUsername() + "-" + user.getPetName());
                } else {
                    onLinefriendList.add(user.getUsername() + "-" + user.getPetName() + unread);
                }
            } else {
                offLinefriendList.add(user.getUsername() + "-" + user.getPetName());
            }
        }
        onLinefriendList.addItemListener(new MainFrame.ListListener());
        offLinefriendList.addItemListener(new MainFrame.ListListener());
        this.setTitle("简易聊天——当前用户为：" + Data.mySelf.getPetName());
    }

    /**
     * 好友列表获取的监听器
     */
    class ListListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {

            String string = onLinefriendList.getSelectedItem();
            //取得账号，split方法分割字符串，存在数组里面！
            String selectUsername = string.split("-")[0];
            System.out.println(selectUsername);
            //由账号取得用户的所有信息
            User user = Data.Friends.get(selectUsername);
            taleToUser = user;
            //当换好友时，更改聊天记录
            reciveBox.setText(taleToUser.getHistoricRecord());
            if (!unread.equals("")) {
                unread = "";
                setFriends(taleToUser.getUsername());
            }
        }
    }

}