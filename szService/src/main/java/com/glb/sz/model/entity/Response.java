package com.glb.sz.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue
    @Column(name = "response_id")
    private
    Integer responseId;

    @Column(name = "response_desc")
    private
    String responseDesc;

    @Column(name = "paper_id")
    @JsonIgnore
    private
    Integer paperId;

    @Column(name = "score_min")
    @JsonIgnore
    private Integer scoreMin;

    @Column(name = "state_id")
    @JsonIgnore
    private Integer stateId;

    public Response(){

    }

    public Response(String responseDesc, Integer paperId, Integer scoreMin, Integer stateId) {
        this.responseDesc = responseDesc;
        this.paperId = paperId;
        this.scoreMin = scoreMin;
        this.stateId = stateId;
    }

    public Response(Integer responseId, String responseDesc, Integer paperId) {
        this.responseId = responseId;
        this.responseDesc = responseDesc;
        this.paperId = paperId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }
}
