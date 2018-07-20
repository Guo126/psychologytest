package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Question;
import com.glb.sz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questionList")
    public BaseResult<List<QuestionDTO>> getQuestionList(@RequestParam("paperId") Integer paperId){
        BaseResult<List<QuestionDTO>> result = new BaseResult<>();
        questionService.getQuestionByPaper(paperId,result);
        return result;
    }

    @GetMapping("/aQuestion")
    public BaseResult<QuestionDTO> getAQuestion(@RequestParam("paperId") Integer paperId,
                                                @RequestParam("numId") Integer numId){
        BaseResult<QuestionDTO> result = new BaseResult<>();
        questionService.getAQuestionByPaper(paperId,numId,result);
        return result;
    }


}
