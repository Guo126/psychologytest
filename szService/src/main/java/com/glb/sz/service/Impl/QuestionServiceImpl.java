package com.glb.sz.service.Impl;

import com.glb.sz.Repository.QuestionRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Question;
import com.glb.sz.service.QuestionService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private
    QuestionRepository questionRepository;

    @Override
    public void getQuestionByPaper(Integer paperId, BaseResult<List<QuestionDTO>> result) {
        List<QuestionDTO> questionDTOList = questionRepository.getQuestionByPaper(paperId);
        ResultUtil.setBaseResult(questionDTOList, result);
    }

    @Override
    public void getAQuestionByPaper(Integer paperId, Integer num, BaseResult<QuestionDTO> result) {
        QuestionDTO questionDTO = questionRepository.getAQuestionByPaper(paperId, num);
        ResultUtil.setBaseResult(questionDTO, result);
    }

    @Override
    public void getQuestionCount(Integer paperId, BaseResult<Integer> result) {
        Integer count = questionRepository.getQuestionCount(paperId);
        ResultUtil.setBaseResult(count,result);
    }

    @Override
    @Transactional
    public void resetQuestion(Integer paperId, Integer questionNum, String questionDesc, BaseResult<Integer> result) {
        Integer r = questionRepository.resetQuestion(paperId,questionNum,questionDesc);
        if(r == 0){
            ResultUtil.setBaseResult("修改失败",false,r,result);
        }else{
            ResultUtil.setBaseResult(r,result);
        }
    }

    @Override
    public void addQuestion(Integer paperId, Integer questionNum, String questionDesc, BaseResult<Question> result) {
        QuestionDTO questionDTO = questionRepository.getAQuestionByPaper(paperId,questionNum);
        if(questionDTO != null){
            ResultUtil.setBaseResult("该题目已存在",false,null,result);
        }

        ResultUtil.setBaseResult(questionRepository.save(new Question(questionDesc,paperId,questionNum)),result);

    }

    @Override
    @Transactional
    public void deleteQuestion(Integer paperId, Integer questionNum, ModifyResult result) {
        Integer r = questionRepository.deleteQuestion(paperId,questionNum);
        if (r == 0){
            ResultUtil.setModifyResult("删除失败,该列不存在",false,result);
        }else{
            ResultUtil.setModifyResult("删除成功",true,result);
        }
    }
}
