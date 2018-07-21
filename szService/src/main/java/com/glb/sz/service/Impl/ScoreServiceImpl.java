package com.glb.sz.service.Impl;

import com.glb.sz.Repository.ScoreRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Score;
import com.glb.sz.service.ScoreService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public void getUserAllScore(Integer userId, BaseResult<List<Score>> result) {
        List<Score> scoreList = scoreRepository.getUserAllScore(userId);
        ResultUtil.setResult(scoreList,result);
    }

    @Override
    public void getUSerScore(Integer userId, Integer responseId, BaseResult<Score> result) {
        Score score = scoreRepository.getUserScore(userId,responseId);
        ResultUtil.setResult(score,result);
    }
}
