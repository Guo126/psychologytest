package com.glb.sz.service.Impl;

import com.glb.sz.Repository.ResponseRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.ResponseWithMinScoreDTO;
import com.glb.sz.model.entity.Response;
import com.glb.sz.service.ResponseService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public void getResponseByPaper(Integer paperId, BaseResult<List<Response>> result) {
        List<Response> responseList = responseRepository.getResponseByPaper(paperId);
        ResultUtil.setBaseResult(responseList, result);
    }

    @Override
    public void getResponseByScore(Integer paperId, Integer score, BaseResult<Response> result) {
        Response response = responseRepository.getResponse(paperId,score);
        ResultUtil.setBaseResult(response,result);
    }

    @Override
    public void getResponseDetail(Integer paperId, BaseResult<List<ResponseWithMinScoreDTO>> result) {
        List<ResponseWithMinScoreDTO> responseWithMinScoreDTO = responseRepository.getResponse(paperId);
        ResultUtil.setBaseResult(responseWithMinScoreDTO,result);
    }

    @Override
    @Transactional
    public void resetResponse(Integer responseId, String responseDesc, ModifyResult result) {
        Integer r = responseRepository.resetResponse(responseId,responseDesc);
        if(r == 0){
            ResultUtil.setModifyResult("要修改的信息不存在",false,result);
        }else{
            ResultUtil.setModifyResult(null,true,result);
        }
    }

    @Override
    public void addResponse(String responseDesc, Integer minScore, Integer paperId, ModifyResult result) {
        responseRepository.save(new Response(responseDesc,paperId,minScore,1));
        ResultUtil.setModifyResult(null,true,result);
    }

    @Override
    @Transactional
    public void deleteResponse(Integer responseId, ModifyResult result) {
        Integer r = responseRepository.deleteResponse(responseId);
        if(r == 0){
            ResultUtil.setModifyResult("要删除的信息不存在",false,result);
        }else{
            ResultUtil.setModifyResult(null,true,result);
        }
    }


}
