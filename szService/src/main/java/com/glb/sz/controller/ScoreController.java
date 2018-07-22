package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Score;
import com.glb.sz.service.ScoreService;
import com.glb.sz.util.IResultBuilder;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/allScore")
    public BaseResult<List<Score>> getUserAllScore(@RequestParam("userId") Integer userId){
        return ResultUtil.buildResult(result -> scoreService.getUserAllScore(userId,result));
    }

    public BaseResult<Score> getUserScore(@RequestParam("userId") Integer userId,
                                          @RequestParam("responseId") Integer responseId){
        return ResultUtil.buildResult(result -> scoreService.getUSerScore(userId,responseId,result));
    }
}
