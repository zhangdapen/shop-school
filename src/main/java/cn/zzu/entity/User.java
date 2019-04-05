package cn.zzu.entity;

/**
 * 测试
 *
 * @author silence
 * @create 2019-04-04-16:55
 */
public class User {

    private String userName;

    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
