package com.glb.sz.service.Impl;

import com.glb.sz.Repository.QuestionRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Question;
import com.glb.sz.service.QuestionService;
import com.glb.sz.util.PageUtil;
import com.glb.sz.util.ResultUtil;
import com.glb.sz.util.builder.IPageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @Transactional
    public void resetQuestion(Integer questionId, String questionDesc, BaseResult<Integer> result) {
        Integer i = questionRepository.resetQuestion(questionId,questionDesc);
        if(i == 0){
            ResultUtil.setBaseResult("该题目不存在",false,null,result);
        }else{
            ResultUtil.setBaseResult(null,true,i,result);
        }

    }

    @Override
    public void addQuestion(Integer paperId, Integer questionNum, String questionDesc, BaseResult<Question> result) {
        QuestionDTO questionDTO = questionRepository.getAQuestionByPaper(paperId,questionNum);
        if(questionDTO != null){
            ResultUtil.setBaseResult("该题目已存在",false,null,result);
        }

        ResultUtil.setBaseResult(questionRepository.save(new Question(questionDesc,paperId,questionNum,1)),result);

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

    @Override
    public void getQuestion(Integer page, Integer pageSize, Integer paperId, BaseResult<Page<Question>> result) {
        ResultUtil.setBaseResult(PageUtil.getPage(page, pageSize, new Question(paperId, 1),
                (IPageBuilder<Question>) (pageRequest, example) -> questionRepository.findAll(example,pageRequest)),result);
    }


}
