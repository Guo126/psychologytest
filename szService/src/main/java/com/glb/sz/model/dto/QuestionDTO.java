package com.glb.sz.model.dto;

public class QuestionDTO {

    private String desc;
    private Integer num;

    public QuestionDTO() {

    }

    public QuestionDTO(String desc, Integer num) {
        this.desc = desc;
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
