package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Response;

import java.util.List;

public interface ResponseService {

    void getResponseByPaper(Integer paperId, BaseResult<List<Response>> result);
    void getResponseByScore(Integer paperId,Integer score,BaseResult<Response> result);
}
