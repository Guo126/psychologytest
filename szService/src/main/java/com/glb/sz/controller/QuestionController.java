package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.QuestionDTO;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.model.entity.Question;
import com.glb.sz.service.QuestionService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questionList")
    public BaseResult<List<QuestionDTO>> getQuestionList(@RequestParam("paperId") Integer paperId) {
        BaseResult<List<QuestionDTO>> result = new BaseResult<>();
        questionService.getQuestionByPaper(paperId, result);
        return result;
    }

    @GetMapping("/aQuestion")
    public BaseResult<QuestionDTO> getAQuestion(@RequestParam("paperId") Integer paperId,
                                                @RequestParam("numId") Integer numId) {
        BaseResult<QuestionDTO> result = new BaseResult<>();
        questionService.getAQuestionByPaper(paperId, numId, result);
        return result;
    }


    @GetMapping("/questionCount")
    public BaseResult<Integer> getPaperCount(@RequestParam("paperId") Integer paperId){
        BaseResult<Integer> result =new BaseResult<>();
        questionService.getQuestionCount(paperId,result);
        return result;
    }

    @PostMapping("/reset")
    public BaseResult<Integer> resetQuestion(@RequestParam(value = "paperId",required = false) Integer paperId,
                                             @RequestParam(value = "questionNum",required = false) Integer questionNum,
                                             @RequestParam(value = "questionId",required = false) Integer questionId,
                                             @RequestParam("questionDesc") String questionDesc) {
        if (paperId != null && questionNum != null)
            return ResultUtil.buildBaseResult(result -> questionService.resetQuestion(paperId, questionNum, questionDesc, result));
        else if (questionId != null)
            return ResultUtil.buildBaseResult(result -> questionService.resetQuestion(questionId, questionDesc, result));
        else
            return new BaseResult<>();
    }

    @PostMapping("/add")
    public BaseResult<Question> addQuestion(@RequestParam("paperId") Integer paperId,
                                            @RequestParam("questionNum") Integer questionNum,
                                            @RequestParam("questionDesc") String questionDesc){
        return ResultUtil.buildBaseResult(result -> questionService.addQuestion(paperId,questionNum,questionDesc,result));
    }

    @PostMapping("/delete")
    public ModifyResult deleteQuestion(@RequestParam("paperId") Integer paperId,
                                       @RequestParam("questionNum") Integer questionNum){
        return ResultUtil.buildModifyResult(result -> questionService.deleteQuestion(paperId,questionNum,result));
    }

    @GetMapping("/getQuestion")
    public BaseResult<Page<Question>> getQuestion(@RequestParam("page") Integer page,
                                                  @RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("paperId") Integer paperId) {
        return ResultUtil.buildBaseResult(result -> questionService.getQuestion(page, pageSize, paperId, result));
    }


}
