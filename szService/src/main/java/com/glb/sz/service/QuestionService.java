package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.PaperDTO;
import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Paper;

import java.util.List;

public interface QuestionService {

    void getQuestionByPaper(Integer paperId, BaseResult<List<QuestionDTO>> result);
    void getAQuestionByPaper(Integer paperId,Integer numId,BaseResult<QuestionDTO> result);
    void getQuestionCount(Integer paperId, BaseResult<Integer> result);
}
