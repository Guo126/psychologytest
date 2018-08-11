package com.glb.sz.model.dto;

public class UserAnswerDTO {

    private Integer responseId;
    private String nickname;
    private String responseDesc;
    private String paperDesc;

    public UserAnswerDTO() {

    }

    public UserAnswerDTO(Integer responseId, String nickname, String responseDesc, String paperDesc) {
        this.responseId = responseId;
        this.nickname = nickname;
        this.responseDesc = responseDesc;
        this.paperDesc = paperDesc;
    }

    public UserAnswerDTO(String nickname, String responseDesc, String paperDesc) {
        this.nickname = nickname;
        this.responseDesc = responseDesc;
        this.paperDesc = paperDesc;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
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
