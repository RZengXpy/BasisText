package javase.day6and7.MulChart.model;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/13 10:45
 */
public class SentCotent implements Serializable {
    private String username;
    private String content;
    //版本号，两个项目需要相同的版本号才能识别，idea一个项目不需要设置版本号！
    private static final long serialVersionUID = 1L;
    public SentCotent() {
    }

    public SentCotent(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
