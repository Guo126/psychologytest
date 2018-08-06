package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.entity.Paper;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PaperService {

    void getPaperList(Integer page,Integer pageSize,BaseResult<Page<Paper>> result);
    void getPaperList(BaseResult<List<Paper>> result);
    void renamePaper(Integer paperId,String newName,BaseResult<Integer> result);
    void addPaper(String paperName,BaseResult<Paper> result);
    void deletePaper(Integer paperId, ModifyResult result);
    void search(String paperDesc,BaseResult<List<Paper>> result);
    void getUserPaper(Integer userId,BaseResult<List<Paper>>result);
}
