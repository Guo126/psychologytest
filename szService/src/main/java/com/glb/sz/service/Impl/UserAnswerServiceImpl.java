package com.glb.sz.service.Impl;

import com.glb.sz.Repository.UserRepository;
import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.UserAnswerDTO;
import com.glb.sz.service.UserAnswerService;
import com.glb.sz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getUserResponseList(Integer userId, BaseResult<List<UserAnswerDTO>> result) {
        List<UserAnswerDTO> userAnswerDTOList = userRepository.getUserResponseList(userId);
        ResultUtil.setResult(userAnswerDTOList, result);
    }
}
