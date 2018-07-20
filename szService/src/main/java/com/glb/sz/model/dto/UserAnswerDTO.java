package com.glb.sz.model.dto;

public class UserAnswerDTO {

    private String nickname;
    private String responseDesc;
    private String paperDesc;

    public UserAnswerDTO(){

    }

    public UserAnswerDTO(String nickname, String responseDesc, String paperDesc) {
        this.nickname = nickname;
        this.responseDesc = responseDesc;
        this.paperDesc = paperDesc;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public String getPaperDesc() {
        return paperDesc;
    }

    public void setPaperDesc(String paperDesc) {
        this.paperDesc = paperDesc;
    }
}
