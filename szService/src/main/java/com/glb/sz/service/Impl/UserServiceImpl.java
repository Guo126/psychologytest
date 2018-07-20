package com.glb.sz.service.Impl;


import com.glb.sz.Repository.UserRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.User;
import com.glb.sz.service.UserService;
import com.glb.sz.util.MD5Util;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void getUser(String username, String password, BaseResult<User> result) {
        User user = userRepository.getUser(username, password);
        ResultUtil.setResult(user, result);
    }

    @Override
    @Transactional
    public void login(Integer userId, BaseResult<User> result) {

        User user = userRepository.getUser(userId);
        if (user == null) {
            ResultUtil.setResult(null, result);
            return;
        }
        int r = userRepository.login(userId, "online");
        if (r == 0) {
            ResultUtil.setResult(null, result);
            return;
        }

        ResultUtil.setResult(user, result);

    }

    @Override
    @Transactional
    public void logout(Integer userId, BaseResult<Object> result) {
        int r = userRepository.logout(userId);
        if (r != 0) {
            ResultUtil.setResult("登出成功", true, r + "", result);
        } else {
            ResultUtil.setResult("登出失败", false, r + "", result);
        }
    }

    @Override
    public void register(String username, String nickname, String password, BaseResult<User> result) {

        User u = userRepository.getUser(username, password);
        if (u != null) {
            ResultUtil.setResult("账号已存在", false, null, result);
        }

        User user = new User(username, MD5Util.getMD5String(password), nickname, "offline");
        userRepository.save(user);

        ResultUtil.setResult(user, result);
    }
}
