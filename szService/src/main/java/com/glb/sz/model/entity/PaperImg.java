package com.glb.sz.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "paper_img")
public class PaperImg {

    @Column(name = "img_id")
    @GeneratedValue
    @Id
    private Integer imgId;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "paper_id")
    private Integer paperId;

    public PaperImg()
    {}

    public PaperImg(Integer imgId, String imgUrl, Integer paperId) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
        this.paperId = paperId;
    }

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

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }
}
