package com.glb.sz.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "paper")
public class Paper {

    @Id
    @GeneratedValue
    @Column(name = "paper_id")
    private
    Integer paperId;

    @Column(name = "paper_desc")
    private
    String paperDesc;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperDesc() {
        return paperDesc;
    }

    public void setPaperDesc(String paperDesc) {
        this.paperDesc = paperDesc;
    }
}
