package javase.newday6and7.Server.data;

import java.util.HashMap;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/13 16:09
 */
public class Data {
    /**
     * 模拟数据库的登录表--存放登录信息
     * @data String
     */
    public static HashMap<String, String> loginInfo = new HashMap<>();
    /**
     * 模拟数据库的用户表--存放用户信息
     * @data User
     */
    public static HashMap<String, Object> users = new HashMap<>();
}
