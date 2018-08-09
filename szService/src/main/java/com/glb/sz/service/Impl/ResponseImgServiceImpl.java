package com.glb.sz.service.Impl;

import com.glb.sz.repository.ResponseImgRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.ResponseImg;
import com.glb.sz.service.ResponseImgService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class ResponseImgServiceImpl implements ResponseImgService {

    @Autowired
    private ResponseImgRepository responseImgRepository;

    @Value(value = "${ResourcePath}")
    private String recoursePath;

    @Value("${getResourcePath}")
    private String urlPath;


    @Override
    public void saveImg(Integer responseId, MultipartFile file,BaseResult<Object> result) {
        String targetPath = recoursePath + "r" + responseId + "\\";
        String url = urlPath + "r" + responseId + "/";
        try {
            byte[] imgBytes = file.getBytes();
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName = dateFormat.format(System.currentTimeMillis())+file.getOriginalFilename();
            File targetFile = new File(targetPath);
            if(!targetFile.exists()){
                if(!targetFile.mkdirs()){
                    ResultUtil.setBaseResult("失败",false,null,result);
                    return;
                }
            }
            Path path = Paths.get(targetPath,fileName);
            Files.write(path,imgBytes);

            url += fileName;
            ResponseImg responseImg = new ResponseImg();
            responseImg.setImgUrl(url);
            responseImg.setResponseId(responseId);

            responseImgRepository.save(responseImg);
            ResultUtil.setBaseResult("成功",true,null,result);
        } catch (IOException e) {
            e.printStackTrace();

            ResultUtil.setBaseResult("失败",false,null,result);
        }
    }

    @Override
    public void getImg(Integer responseId, BaseResult<List<ResponseImg>> result) {
        List<ResponseImg> responseImgList = responseImgRepository.getImg(responseId);
        ResultUtil.setBaseResult(responseImgList,result);
    }
}
