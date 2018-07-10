package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.UserDTO;
import com.glb.sz.model.entity.User;

import java.util.List;

public interface UserService {

    void getAllUser(BaseResult<List<User>> result) ;


    void findByLogin(String username,String password,BaseResult<User> result);

    void register(String username,String password,BaseResult<UserDTO> result);
}
