package com.glb.sz.model.dto;

import java.util.Date;

public class UserMessageDTO {

    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String sex;
    private String self_desc;
    private String mail;
    private Date birthday;



    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getSelf_desc() {
        return self_desc;
    }

    public void setSelf_desc(String self_desc) {
        this.self_desc = self_desc;
    }

    @Override
    public String toString() {
        return
                "username='" + username + '\'' +
                ",password='" + password + '\'' +
                ",nickname='" + nickname + '\'' +
                ",phone='" + phone + '\'' +
                ",sex='" + sex + '\'' +
                ",self_desc='" + self_desc;
    }
}
