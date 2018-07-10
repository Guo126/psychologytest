package com.glb.sz.controller;


import com.glb.sz.model.entity.Admin;
import com.glb.sz.model.BaseResult;

import com.glb.sz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {


    @Autowired
   AdminService adminService;

    @GetMapping("/admin")
    public BaseResult<List<Admin>> getAdmin(){
        BaseResult<List<Admin>> result = new BaseResult<>();
        adminService.getAllAdmin(result);
        return result;
    }
}
