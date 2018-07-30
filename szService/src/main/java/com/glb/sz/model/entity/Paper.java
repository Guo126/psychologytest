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

    @Column(name ="state_id")
    private Integer stateId;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

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
