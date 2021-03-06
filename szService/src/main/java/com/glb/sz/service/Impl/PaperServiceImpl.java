package com.glb.sz.service.Impl;

import com.glb.sz.repository.PaperRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.entity.Paper;
import com.glb.sz.service.PaperService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @Override
    public void getPaperList(Integer page,Integer pageSize, BaseResult<Page<Paper>> result) {
        PageRequest pageRequest = PageRequest.of(page,pageSize);
        Paper paper = new Paper();
        paper.setStateId(1);
        Example<Paper> paperExample = Example.of(paper);
        ResultUtil.setBaseResult(paperRepository.findAll(paperExample,pageRequest),result);
    }

    @Override
    public void getPaperList(BaseResult<List<Paper>> result) {
        List<Paper> paperList = paperRepository.getPaperList();
        ResultUtil.setBaseResult(paperList, result);
    }

    @Override
    @Transactional
    public void renamePaper(Integer paperId, String newName, BaseResult<Integer> result) {
        Integer r = paperRepository.renamePaper(paperId,newName);
        if(r == 0){
            ResultUtil.setBaseResult("改名失败,名字不规范",false,r,result);
        }else{
            ResultUtil.setBaseResult(r,result);
        }
    }

    @Override
    public void addPaper(String paperName, BaseResult<Paper> result) {
        Paper paper = new Paper(paperName,1);
        ResultUtil.setBaseResult(paperRepository.save(paper),result);
    }

    @Override
    @Transactional
    public void deletePaper(Integer paperId, ModifyResult result) {
        Integer r = paperRepository.deletePaper(paperId);
        if(r == 0){
            ResultUtil.setModifyResult("删除失败",false,result);
        }else{
            ResultUtil.setModifyResult("删除成功",true,result);
        }
    }

    @Override
    public void search(String paperDesc, BaseResult<List<Paper>> result) {
        List<Paper> paperList = paperRepository.search(paperDesc);
        if(paperList.size() == 0){
            ResultUtil.setBaseResult("卷子不存在啊喂",false,null,result);
        }else{
            ResultUtil.setBaseResult("这就是你要的卷子啊",true,paperList,result);
        }
    }

    @Override
    public void getUserPaper(Integer userId, BaseResult<List<Paper>> result) {
        ResultUtil.setBaseResult(paperRepository.getPaperByUser(userId),result);
    }
}
