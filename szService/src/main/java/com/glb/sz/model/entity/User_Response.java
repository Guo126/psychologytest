package com.glb.sz.model.entity;

import com.glb.sz.model.entity.pk.User_Response_ID;

import javax.persistence.*;

@Entity
@Table(name = "user_response")
@IdClass(User_Response_ID.class)
public class User_Response {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "response_id")
    private Integer responseId;

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
}
