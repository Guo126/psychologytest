package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.Paper;

import java.util.List;

public interface PaperService {

    void getPaperList(BaseResult<List<Paper>> result);
}
