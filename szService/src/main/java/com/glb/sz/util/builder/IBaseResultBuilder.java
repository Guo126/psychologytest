package com.glb.sz.util.builder;

import com.glb.sz.model.BaseResult;

public interface IBaseResultBuilder<T> {
    void buildResult(BaseResult<T> result);
}
