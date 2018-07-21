package com.glb.sz.service.Impl;

import com.glb.sz.Repository.QuestionRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.service.QuestionService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private
    QuestionRepository questionRepository;

    @Override
    public void getQuestionByPaper(Integer paperId, BaseResult<List<QuestionDTO>> result) {
        List<QuestionDTO> questionDTOList = questionRepository.getQuestionByPaper(paperId);
        ResultUtil.setResult(questionDTOList, result);
    }

    @Override
    public void getAQuestionByPaper(Integer paperId, Integer num, BaseResult<QuestionDTO> result) {
        QuestionDTO questionDTO = questionRepository.getAQuestionByPaper(paperId, num);
        ResultUtil.setResult(questionDTO, result);
    }
}
