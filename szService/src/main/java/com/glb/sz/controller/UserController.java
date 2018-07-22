package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.entity.User;
import com.glb.sz.service.UserService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BaseResult<User> register(@RequestParam("username") String username,
                                     @RequestParam("nickname") String nickname,
                                     @RequestParam("password") String password) {
        return ResultUtil.buildResult(result -> userService.register(username,nickname,password,result));
    }

    @GetMapping("/getUser")
    public BaseResult<User> getUser(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        return ResultUtil.buildResult(result -> userService.getUser(username,password,result));
    }

    @PostMapping("/login")
    public BaseResult<User> login(@RequestParam("userId") Integer userId) {
        return ResultUtil.buildResult(result -> userService.login(userId,result));
    }

    @PostMapping("/logout")
    private BaseResult<Object> logout(@RequestParam("userId") Integer userId) {
        return ResultUtil.buildResult(result -> userService.logout(userId,result));
    }

}
