package com.glb.sz.model.entity;

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
    private
    Integer paperId;

    public Response(){

    }

    public Response(Integer responseId, String responseDesc, Integer paperId) {
        this.responseId = responseId;
        this.responseDesc = responseDesc;
        this.paperId = paperId;
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
