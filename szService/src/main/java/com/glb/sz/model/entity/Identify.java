package com.glb.sz.model.entity;

import javax.persistence.*;


@Entity
@Table(name = "identify")
public class Identify {
    @Id
    @GeneratedValue
    @Column(name = "identify_id")
    private Integer identifyId;

    @Column(name = "level")
    private Integer level;

    @Column(name = "level_desc")
    private String levelDesc;

    public Integer getIdentifyId() {
        return identifyId;
    }

    public void setIdentifyId(Integer identifyId) {
        this.identifyId = identifyId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }
}
