package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.ResponseImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResponseImgService {

    void saveImg(Integer responseId, MultipartFile file,BaseResult<Object> result);
    void getImg(Integer responseId, BaseResult<List<ResponseImg>> result);
}
