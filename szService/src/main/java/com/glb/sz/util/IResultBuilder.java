package com.glb.sz.util;

import com.glb.sz.model.BaseResult;

public interface IResultBuilder<T> {
    void buildResult(BaseResult<T> result);
}
