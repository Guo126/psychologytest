package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping("/getPaperList")
    public BaseResult<List<Paper>> getPaperList() {
        BaseResult<List<Paper>> paperList = new BaseResult<>();
        paperService.getPaperList(paperList);
        return paperList;
    }


}
