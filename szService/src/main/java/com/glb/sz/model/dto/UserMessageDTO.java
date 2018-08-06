package com.glb.sz.model.dto;

public class UserMessageDTO {

    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String sex;
    private String desc;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return
                "username='" + username + '\'' +
                ",password='" + password + '\'' +
                ",nickname='" + nickname + '\'' +
                ",phone='" + phone + '\'' +
                ",sex='" + sex + '\'' +
                ",desc='" + desc;
    }
}
