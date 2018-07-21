package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Score;

import java.util.List;

public interface ScoreService {

    void getUserAllScore(Integer userId, BaseResult<List<Score>> result);
    void getUSerScore(Integer userId,Integer responseId,BaseResult<Score> result);
}
