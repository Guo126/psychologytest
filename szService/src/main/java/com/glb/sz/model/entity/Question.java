package com.glb.sz.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Column(name = "question_id")
    @GeneratedValue
    @Id
    private Integer questionId;

    @Column(name = "question_desc")
    private
    String questionDesc;


    @Column(name = "paper_id")
    @JsonIgnore
    private
    Integer paperId;


    @Column(name = "question_num")
    private Integer questionNum;

    @Column(name = "stateId")
    @JsonIgnore
    private Integer stateId;

    public Question(){

    }

    public Question(Integer paperId, Integer stateId) {
        this.paperId = paperId;
        this.stateId = stateId;
    }

    public Question(String questionDesc, Integer paperId, Integer questionNum) {
        this.questionDesc = questionDesc;
        this.paperId = paperId;
        this.questionNum = questionNum;
    }

    public Question(String questionDesc, Integer paperId, Integer questionNum, Integer stateId) {
        this.questionDesc = questionDesc;
        this.paperId = paperId;
        this.questionNum = questionNum;
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }


    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }
}
