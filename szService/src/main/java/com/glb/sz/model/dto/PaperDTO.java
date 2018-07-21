package com.glb.sz.model.dto;

import com.glb.sz.model.entity.Paper;

import java.util.List;

public class PaperDTO {

    private List<Paper> paperList;
    private Integer coount;

    public PaperDTO() {

    }

    public PaperDTO(List<Paper> paperList, Integer coount) {
        this.paperList = paperList;
        this.coount = coount;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public Integer getCoount() {
        return coount;
    }

    public void setCoount(Integer coount) {
        this.coount = coount;
    }
}
