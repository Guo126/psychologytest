package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.entity.Paper;

import java.util.List;

public interface PaperService {

    void getPaperList(BaseResult<List<Paper>> result);
    void renamePaper(Integer paperId,String newName,BaseResult<Integer> result);
    void addPaper(String paperName,BaseResult<Paper> result);
    void deletePaper(Integer paperId, ModifyResult result);
}
