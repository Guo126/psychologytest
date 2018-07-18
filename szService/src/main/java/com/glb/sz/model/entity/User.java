package com.glb.sz.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private
    Integer userId;
    @Column(name="username")
    private
    String username;
    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sex")
    private String sex;

    @Column(name = "desc")
    private String desc;

    @Column(name = "token")
    private String token;

    public User(){

    }

    public User(String username, String password, String nickname, String phone, String sex, String desc, String token) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.sex = sex;
        this.desc = desc;
        this.token = token;
    }

    public User(String username, String password, String nickname, String token) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
