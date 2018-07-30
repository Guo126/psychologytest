package com.glb.sz.model.entity.pk;

import java.io.Serializable;

public class QuestionPK implements Serializable {
    private Integer paperId;
    private Integer questionNum;
    public QuestionPK(){

    }

    public QuestionPK(Integer paperId, Integer questionNum) {
        this.paperId = paperId;
        this.questionNum = questionNum;
    }
}
