package com.glb.sz.service.Impl;

import com.glb.sz.Repository.PaperRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.service.PaperService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @Override
    public void getPaperList(BaseResult<List<Paper>> result) {
        List<Paper> paperList = paperRepository.getPaperList();
        ResultUtil.setResult(paperList,result);
    }
}
