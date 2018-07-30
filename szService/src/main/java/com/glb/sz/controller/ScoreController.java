package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Score;
import com.glb.sz.service.ScoreService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/allScore")
    public BaseResult<List<Score>> getUserAllScore(@RequestParam("userId") Integer userId){
        return ResultUtil.buildBaseResult(result -> scoreService.getUserAllScore(userId,result));
    }

    @GetMapping("/getAScore")
    public BaseResult<Score> getUserScore(@RequestParam("userId") Integer userId,
                                          @RequestParam("responseId") Integer responseId){
        return ResultUtil.buildBaseResult(result -> scoreService.getUSerScore(userId,responseId,result));
    }

    @PostMapping("/saveResponse")
    public BaseResult<Object> saveUserScore(@RequestParam("userId") Integer userId,
                                            @RequestParam("responseId") Integer responseId,
                                            @RequestParam("score") Integer score){
        return ResultUtil.buildBaseResult(result -> scoreService.setUserScore(new Score(userId,responseId,score),result));
    }
}
