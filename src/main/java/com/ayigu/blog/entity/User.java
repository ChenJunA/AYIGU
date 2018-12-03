package com.ayigu.blog.entity;

/**
 * @Description: 后台管理员信息类
 * @Author: chenjun
 * @Date: 2018/11/30 14:54
 */
public class User {
    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
