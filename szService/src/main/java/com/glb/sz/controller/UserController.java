package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.UserDTO;
import com.glb.sz.model.entity.User;
import com.glb.sz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/user")
    public BaseResult<List<User>> getUser(){
        BaseResult<List<User>> result = new BaseResult<>();
        userService.getAllUser(result);
        return result;
    }


    @GetMapping("/register")
    public BaseResult<UserDTO> register(@RequestParam("username") String username,
                                        @RequestParam("password") String password){
        BaseResult<UserDTO> result = new BaseResult<>();
        userService.register(username,password,result);
        return result;
    }

    @GetMapping("/login")
    public BaseResult<User> login(@RequestParam("username") String username,
                                  @RequestParam("password") String password){
        BaseResult<User> r = new BaseResult<>();
        userService.findByLogin(username,password,r);
        return r;
    }
}
