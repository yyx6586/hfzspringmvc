package yyx.user.bean;

import java.util.Date;

public class User {
    private String account;

    private String name;

    private String password;

    private int role;

    private Date create_time;

    private Date update_time;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date creat_time) {
        this.create_time = creat_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
