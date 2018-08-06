package com.glb.sz.service.Impl;


import com.glb.sz.Repository.UserRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.UserMessageDTO;
import com.glb.sz.model.entity.User;
import com.glb.sz.service.UserService;
import com.glb.sz.util.MD5Util;
import com.glb.sz.util.ResultUtil;
import com.glb.sz.util.UpdateUtil;
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
        ResultUtil.setBaseResult(user, result);
    }

    @Override
    @Transactional
    public void login(Integer userId, BaseResult<User> result) {

        User user = userRepository.getUser(userId);
        if (user == null) {
            ResultUtil.setBaseResult(null, result);
            return;
        }
        int r = userRepository.login(userId, "online");
        if (r == 0) {
            ResultUtil.setBaseResult(null, result);
            return;
        }

        ResultUtil.setBaseResult(user, result);

    }

    @Override
    @Transactional
    public void logout(Integer userId, BaseResult<Object> result) {
        int r = userRepository.logout(userId);
        if (r != 0) {
            ResultUtil.setBaseResult("登出成功", true, r + "", result);
        } else {
            ResultUtil.setBaseResult("登出失败", false, r + "", result);
        }
    }

    @Override
    public void register(String username, String nickname, String password, BaseResult<User> result) {

        User u = userRepository.getUser(username, password);
        if (u != null) {
            ResultUtil.setBaseResult("账号已存在", false, null, result);
        }

        User user = new User(username, MD5Util.getMD5String(password), nickname, "offline");
        userRepository.save(user);

        ResultUtil.setBaseResult(user, result);
    }

    @Override
    public void changeUserMessage(Integer userId, UserMessageDTO userMessageDTO, BaseResult<User> result) {
        User user = userRepository.getUser(userId);
        if(user == null){
            ResultUtil.setBaseResult("该用户不存在",false,null,result);
            return;
        }

        user = UpdateUtil.updateAObj(user,userMessageDTO.toString());
        if(user == null){
            ResultUtil.setBaseResult("用户保存失败",false,null,result);
            return;
        }

        userRepository.save(user);
        ResultUtil.setBaseResult("用户保存成功",true,user,result);
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId, ModifyResult result) {
        ResultUtil.setModifyResult(null, userRepository.deleteUser(userId) == 1,result);
    }
}
