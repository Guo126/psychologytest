package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Response;
import com.glb.sz.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping("/getResponse")
    public BaseResult<List<Response>> getResponseByPaper(@RequestParam("paperId") Integer paperId){
        BaseResult<List<Response>> result = new BaseResult<>();
        responseService.getResponseByPaper(paperId,result);
        return result;
    }

}
