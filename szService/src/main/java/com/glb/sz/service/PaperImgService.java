package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.PaperImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PaperImgService {
    void saveImg(Integer paperId, MultipartFile file, BaseResult<Object> result);
    void getImg(Integer paperId, BaseResult<List<PaperImg>> result);
}
