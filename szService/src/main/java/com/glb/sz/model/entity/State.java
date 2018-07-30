package com.glb.sz.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "state_desc")
    private String stateDesc;

    public State(){
    }

    public State(Integer stateId, String stateDesc) {
        this.stateId = stateId;
        this.stateDesc = stateDesc;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }
}
