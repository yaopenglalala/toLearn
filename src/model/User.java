package model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String password;

    public User(){
        userId = 0;
        userName = "";
        password = "";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userid) {
        this.userId = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
