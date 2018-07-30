package com.glb.sz.model.dto;

public class ResponseWithMinScoreDTO {

    private Integer minScore;
    private String responseDesc;
    private Integer responseId;

    public ResponseWithMinScoreDTO(Integer minScore, String responseDesc, Integer responseId) {
        this.minScore = minScore;
        this.responseDesc = responseDesc;
        this.responseId = responseId;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }
}
