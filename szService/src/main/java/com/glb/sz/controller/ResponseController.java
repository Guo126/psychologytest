package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.ResponseWithMinScoreDTO;
import com.glb.sz.model.entity.Response;
import com.glb.sz.model.entity.ResponseImg;
import com.glb.sz.service.ResponseImgService;
import com.glb.sz.service.ResponseService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private ResponseImgService responseImgService;

    @GetMapping("/getResponse")
    public BaseResult<List<Response>> getResponseByPaper(@RequestParam("paperId") Integer paperId) {
        BaseResult<List<Response>> result = new BaseResult<>();
        responseService.getResponseByPaper(paperId, result);
        return result;
    }

    @GetMapping("/getResponseByScore")
    public BaseResult<Response> getResponseByScore(@RequestParam("paperId") Integer paperId,
                                                   @RequestParam("score") Integer score){
        return ResultUtil.buildBaseResult(result -> responseService.getResponseByScore(paperId,score,result));
    }

    @GetMapping("/getImg")
    public BaseResult<List<ResponseImg>> getResponseImgList(@RequestParam("responseId") Integer responseId){
        return ResultUtil.buildBaseResult(result -> responseImgService.getImg(responseId,result));
    }

    @PostMapping("/saveImg")
    public BaseResult<Object> saveImg(@RequestParam("responseId") Integer responseId,
                                      @RequestParam("img") MultipartFile img){
        return ResultUtil.buildBaseResult(result -> responseImgService.saveImg(responseId,img,result));
    }

    @GetMapping("/getResponseDetail")
    public BaseResult<List<ResponseWithMinScoreDTO>> getResponseDetail(@RequestParam("paperId") Integer paperId){
        return ResultUtil.buildBaseResult(result -> responseService.getResponseDetail(paperId,result));
    }

    @PostMapping("/delete")
    public ModifyResult deleteResponse(@RequestParam("responseId") Integer responseId){
        return ResultUtil.buildModifyResult(result -> responseService.deleteResponse(responseId,result));
    }

    @PostMapping("/reset")
    public ModifyResult resetResponse(@RequestParam("responseId") Integer responseId,
                                      @RequestParam("responseDesc") String responseDesc){
        return ResultUtil.buildModifyResult(result -> responseService.resetResponse(responseId,responseDesc,result));
    }

    @PostMapping("/add")
    public ModifyResult addResponse(@RequestParam("responseDesc") String responseDesc,
                                    @RequestParam("paperId") Integer paperId,
                                    @RequestParam("minScore") Integer minScore){
        return ResultUtil.buildModifyResult(result -> responseService.addResponse(responseDesc,minScore,paperId,result));
    }

}
