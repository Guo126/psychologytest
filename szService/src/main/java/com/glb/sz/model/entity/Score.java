package com.glb.sz.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glb.sz.model.entity.pk.Score_ID;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;

@Entity
@Table(name = "score")
@IdClass(Score_ID.class)
public class Score {

    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private Integer userId;
    @Id
    @Column(name = "response_id")
    private Integer responseId;
    @Column(name = "score")
    private Integer score;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
