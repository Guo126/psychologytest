package com.glb.sz.controller;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.model.dto.UserMessageDTO;
import com.glb.sz.model.entity.User;
import com.glb.sz.service.UserService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BaseResult<User> register(@RequestParam("username") String username,
                                     @RequestParam("nickname") String nickname,
                                     @RequestParam("password") String password,
                                     @RequestParam(value = "sex",required = false) String sex,
                                     @RequestParam(value = "phone",required = false)String phone,
                                     @RequestParam(value = "mail",required = false) String mail,
                                     @RequestParam(value = "desc",required = false) String desc,
                                     @RequestParam(value = "birthday",required = false)String b) {
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyMMdd").parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalBirthday = birthday;
        return ResultUtil.buildBaseResult(result -> userService.register(username,nickname,password,sex,phone,mail,desc, finalBirthday,result));
    }

    @GetMapping("/getUser")
    public BaseResult<User> getUser(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        return ResultUtil.buildBaseResult(result -> userService.getUser(username,password,result));
    }

    @PostMapping("/login")
    public BaseResult<User> login(@RequestParam("userId") Integer userId) {
        return ResultUtil.buildBaseResult(result -> userService.login(userId,result));
    }

    @PostMapping("/logout")
    public BaseResult<Object> logout(@RequestParam("userId") Integer userId) {
        return ResultUtil.buildBaseResult(result -> userService.logout(userId,result));
    }

    @PostMapping("/change")
    public BaseResult<User> changeUserMessage(@RequestParam("userId") Integer userId,
                                              @RequestBody UserMessageDTO userMessageDTO){
        return ResultUtil.buildBaseResult(result -> userService.changeUserMessage(userId,userMessageDTO,result));
    }

    @PostMapping("/delete")
    public ModifyResult delete(@RequestParam("userId") Integer userId){
        return ResultUtil.buildModifyResult(result -> userService.deleteUser(userId,result));
    }

    @PostMapping("/search")
    public BaseResult<List<User>> seacrh(@RequestParam("nickname") String nickname){
        return ResultUtil.buildBaseResult(result -> userService.searchUser(nickname,result));
    }
}
