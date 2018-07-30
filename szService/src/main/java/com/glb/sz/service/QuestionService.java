package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.PaperDTO;
import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.model.entity.Question;

import java.util.List;

public interface QuestionService {

    void getQuestionByPaper(Integer paperId, BaseResult<List<QuestionDTO>> result);
    void getAQuestionByPaper(Integer paperId,Integer numId,BaseResult<QuestionDTO> result);
    void getQuestionCount(Integer paperId, BaseResult<Integer> result);
    void resetQuestion(Integer paperId,Integer questionNum,String questionDesc,BaseResult<Integer> result);
    void addQuestion(Integer paperId,Integer questionNum,String questionDesc,BaseResult<Question> result);
    void deleteQuestion(Integer paperId, Integer questionNum, ModifyResult result);
}
