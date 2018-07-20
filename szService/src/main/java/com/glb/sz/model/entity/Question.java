package com.glb.sz.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private
    Integer questionId;

    @Column(name = "question_desc")
    private
    String questionDesc;

    @Column(name = "paper_id")
    private
    Integer paperId;

    @Column(name = "question_num")
    private Integer quesionNum;

    public Integer getQuesionNum() {
        return quesionNum;
    }

    public void setQuesionNum(Integer quesionNum) {
        this.quesionNum = quesionNum;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
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
