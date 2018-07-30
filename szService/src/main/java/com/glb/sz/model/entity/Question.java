package com.glb.sz.model.entity;

import com.glb.sz.model.entity.pk.QuestionPK;

import javax.persistence.*;

@Entity
@Table(name = "question")
@IdClass(QuestionPK.class)
public class Question {

    @Column(name = "question_desc")
    private
    String questionDesc;

    @Id
    @Column(name = "paper_id")
    private
    Integer paperId;

    @Id
    @Column(name = "question_num")
    private Integer questionNum;

    @Column(name = "stateId")
    private Integer stateId;

    public Question(){

    }

    public Question(String questionDesc, Integer paperId, Integer questionNum) {
        this.questionDesc = questionDesc;
        this.paperId = paperId;
        this.questionNum = questionNum;
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
