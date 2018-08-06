package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.ResponseWithMinScoreDTO;
import com.glb.sz.model.dto.SearchResponseResultDTO;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.model.entity.Response;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ResponseService {

    void getResponseByPaper(Integer paperId, BaseResult<List<Response>> result);
    void getResponseByScore(Integer paperId,Integer score,BaseResult<Response> result);
    void getResponseDetail(Integer paperId, BaseResult<List<ResponseWithMinScoreDTO>> result);
    void resetResponse(Integer responseId,Integer minScore, String responseDesc, ModifyResult result);
    void addResponse(String responseDesc, Integer minScore, Integer paperId, ModifyResult result);
    void deleteResponse(Integer responseId, ModifyResult result);
    void getResponse(Integer page,Integer pageSize,BaseResult<Page<Response>> result);
    void search(String responseDesc, BaseResult<List<SearchResponseResultDTO>> result);
}
