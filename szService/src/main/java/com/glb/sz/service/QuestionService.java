package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    void getQuestionByPaper(Integer paperId, BaseResult<List<QuestionDTO>> result);
    void getAQuestionByPaper(Integer paperId,Integer numId,BaseResult<QuestionDTO> result);
}
