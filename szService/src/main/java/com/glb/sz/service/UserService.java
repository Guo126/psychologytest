package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.UserMessageDTO;
import com.glb.sz.model.entity.User;

public interface UserService {

    void getUser(String username, String password,BaseResult<User> result);
    void login(Integer userId,BaseResult<User> result);
    void logout(Integer userId,BaseResult<Object> result);
    void register(String username,String nickname,String password,BaseResult<User> result);
    void changeUserMessage(Integer userId, UserMessageDTO userMessageDTO,BaseResult<User> result);
}
