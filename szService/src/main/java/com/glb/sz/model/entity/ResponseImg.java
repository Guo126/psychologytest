package com.glb.sz.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "response_img")
public class ResponseImg {

    @Id
    @GeneratedValue
    @Column(name = "img_id")
    private Integer imgId;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "response_id")
    @JsonIgnore
    private Integer responseId;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }
}
