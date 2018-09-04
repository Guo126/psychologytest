package com.glb.sz.service.Impl;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.PaperImg;
import com.glb.sz.repository.PaperImgRepository;
import com.glb.sz.service.PaperImgService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PaperImgServicelmpl implements PaperImgService {

    @Autowired
    private PaperImgRepository paperImgRepository;

    @Value(value = "${ResourcePath}")
    private String recoursePath;

    @Value("${getResourcePath}")
    private String urlPath;


    @Override
    public void saveImg(Integer paperId, MultipartFile file, BaseResult<Object> result) {
        String targetPath = recoursePath + "r" + paperId + "\\";
        String url = urlPath + "p" + paperId + "/";
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
            PaperImg paperImg = new PaperImg();
            paperImg.setImgUrl(url);
            paperImg.setPaperId(paperId);

            paperImgRepository.save(paperImg);
            ResultUtil.setBaseResult("成功",true,null,result);
        } catch (IOException e) {
            e.printStackTrace();

            ResultUtil.setBaseResult("失败",false,null,result);
        }
    }

    @Override
    public void getImg(Integer paperId, BaseResult<List<PaperImg>> result) {
        List<PaperImg> responseImgList = paperImgRepository.getImg(paperId);
        ResultUtil.setBaseResult(responseImgList,result);
    }
}
