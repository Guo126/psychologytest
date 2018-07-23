package com.glb.sz.service.Impl;

import com.glb.sz.Repository.ResponseRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Response;
import com.glb.sz.service.ResponseService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public void getResponseByPaper(Integer paperId, BaseResult<List<Response>> result) {
        List<Response> responseList = responseRepository.getResponseByPaper(paperId);
        ResultUtil.setResult(responseList, result);
    }

    @Override
    public void getResponseByScore(Integer paperId, Integer score, BaseResult<Response> result) {
        Response response = responseRepository.getResponse(paperId,score);
        ResultUtil.setResult(response,result);
    }
}
