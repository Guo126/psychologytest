package com.glb.sz.model.dto;

public class SearchResponseResultDTO {

    private String responseDesc;
    private String paperDesc;
    private Integer scoreMin;

    public SearchResponseResultDTO(String responseDesc, String paperDesc, Integer scoreMin) {
        this.responseDesc = responseDesc;
        this.paperDesc = paperDesc;
        this.scoreMin = scoreMin;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public String getPaperDesc() {
        return paperDesc;
    }

    public void setPaperDesc(String paperDesc) {
        this.paperDesc = paperDesc;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }
}
