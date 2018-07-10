package com.glb.sz.service;

import com.glb.sz.model.entity.Admin;
import com.glb.sz.model.BaseResult;

import java.util.List;

public interface AdminService {

    void getAllAdmin(BaseResult<List<Admin>> result);

}
