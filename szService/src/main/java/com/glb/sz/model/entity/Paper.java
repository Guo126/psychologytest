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

    public Paper(){

    }

    public Paper(String paperDesc, Integer stateId) {
        this.paperDesc = paperDesc;
        this.stateId = stateId;
    }

    public Paper(Integer paperId, String paperDesc, Integer stateId) {
        this.paperId = paperId;
        this.paperDesc = paperDesc;
        this.stateId = stateId;
    }

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
