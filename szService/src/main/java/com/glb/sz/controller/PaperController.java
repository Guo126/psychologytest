package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.service.PaperService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/getPaper")
    public BaseResult<Page<Paper>> getPaperList(@RequestParam("page") Integer page,
                                                @RequestParam("pageSize") Integer pageSize){
        return ResultUtil.buildBaseResult(result -> paperService.getPaperList(page,pageSize,result));
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
