package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.service.PaperService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/rename")
    public BaseResult<Integer> renamePaper(@RequestParam("paperId") Integer paperId,
                                           @RequestParam("paperDesc") String paperDesc){
        return ResultUtil.buildBaseResult(result -> paperService.renamePaper(paperId,paperDesc,result));
    }

    @PostMapping("/add")
    public BaseResult<Paper> addPaper(@RequestParam("paperDesc") String paperDesc){
        return ResultUtil.buildBaseResult(result -> paperService.addPaper(paperDesc,result));
    }

    @PostMapping("/delete")
    public ModifyResult deletePaper(@RequestParam("paperId") Integer paperId){
        return ResultUtil.buildModifyResult(result -> paperService.deletePaper(paperId,result));
    }


}
