package com.glb.sz.controller;


import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.UserAnswerDTO;
import com.glb.sz.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @GetMapping("/responseList")
    public BaseResult<List<UserAnswerDTO>> getUserAnswerList(@RequestParam("userId") Integer userId) {
        BaseResult<List<UserAnswerDTO>> result = new BaseResult<>();
        userAnswerService.getUserResponseList(userId, result);
        return result;
    }

}
