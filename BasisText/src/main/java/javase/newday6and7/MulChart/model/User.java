package javase.newday6and7.MulChart.model;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/13 8:47
 */
public class User implements Serializable {
    /**
     * 版本号，两个项目需要相同的版本号才能识别，idea一个项目不需要设置版本号！
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户昵称
     */
    private String petName;
    /**
     * 当前客户端IP地址
     */
    private String host;
    /**
     * 当前客户端端口号
     */
    private  int port;
    /**
     * 历史聊天记录
     */
    private  String historicRecord;
    /**
     * 用户在线状态
     * ture 在线
     * false 离线
     */
    private boolean isOnline;

    public User() {
    }

    public User(String username, String petName, String host, int port, String historicRecord, boolean isOnline) {
        this.username = username;
        this.petName = petName;
        this.host = host;
        this.port = port;
        this.historicRecord = historicRecord;
        this.isOnline = isOnline;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", petName='" + petName + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", historicRecord='" + historicRecord + '\'' +
                ", isOnline=" + isOnline +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHistoricRecord() {
        return historicRecord;
    }

    public void setHistoricRecord(String historicRecord) {
        this.historicRecord = historicRecord;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
