package com.glb.sz.service;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.dto.UserAnswerDTO;

import java.util.List;

public interface UserAnswerService {

    void getUserResponseList(Integer userId, BaseResult<List<UserAnswerDTO>> result);

}
