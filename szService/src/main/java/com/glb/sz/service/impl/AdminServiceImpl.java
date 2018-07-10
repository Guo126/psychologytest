package com.glb.sz.service.impl;

import com.glb.sz.Repository.AdminRepository;
import com.glb.sz.model.entity.Admin;
import com.glb.sz.model.BaseResult;
import com.glb.sz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;



    @Override
    public void getAllAdmin(BaseResult<List<Admin>> result) {
        List<Admin> adminList = adminRepository.getAllAdmin();
        if(adminList!= null){
            result.setMessage("成功");
            result.setSuccess(true);
            result.setData(adminList);
        }else{
            result.setMessage("失败");
            result.setSuccess(false);
        }
    }
}
