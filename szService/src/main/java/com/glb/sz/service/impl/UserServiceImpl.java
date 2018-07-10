package com.glb.sz.service.impl;

import com.glb.sz.Repository.UserRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.UserDTO;
import com.glb.sz.model.entity.Admin;
import com.glb.sz.model.entity.User;
import com.glb.sz.service.AdminService;
import com.glb.sz.service.UserService;
import com.glb.sz.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void getAllUser(BaseResult<List<User>> result) {
        List<User> userList = userRepository.getAllUser();
        if(userList!=null){
            result.setSuccess(true);
            result.setMessage("成功");
            result.setData(userList);

        }
        else{
            result.setSuccess(false);
            result.setMessage("失败");
        }

    }

    @Override
    public void findByLogin(String username, String password, BaseResult<User> result) {
        User user = userRepository.findByLogin(username,password);
        if(user != null){
            result.setSuccess(true);
            result.setData(user);
            result.setMessage("success");
        }else{
            result.setMessage("fail");
            result.setSuccess(false);
        }
    }

    @Override
    public void register(String username, String password, BaseResult<UserDTO> result) {
        User user = new User();
        user.setUserPassword(MD5Util.getMD5String(password));
        user.setUserName(username);

        userRepository.save(user);
    }

}
