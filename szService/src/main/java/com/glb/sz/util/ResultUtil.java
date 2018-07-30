package com.glb.sz.util;

import com.glb.sz.model.BaseResult;
import com.glb.sz.model.ModifyResult;
import com.glb.sz.util.builder.IBaseResultBuilder;
import com.glb.sz.util.builder.IModifyResultBuilder;

public class ResultUtil {

    public static <T> BaseResult<T> buildBaseResult(IBaseResultBuilder<T> builder){
        BaseResult<T> baseResult = new BaseResult<>();
        builder.buildResult(baseResult);
        return baseResult;
    }

    public static ModifyResult buildModifyResult(IModifyResultBuilder builder){
        ModifyResult modifyResult = new ModifyResult();
        builder.build(modifyResult);
        return modifyResult;
    }

    public static void setModifyResult(String message,boolean isSuccess,ModifyResult result){
        result.setMessage(message);
        result.setSuccess(isSuccess);
    }


    public static <T> void setBaseResult(String message, boolean isSuccess, T data, BaseResult<T> result){
        result.setMessage(message);
        result.setSuccess(isSuccess);
        result.setData(data);
    }

    public static <T> void setBaseResult(T data, BaseResult<T> result){
        if(data == null){
            setBaseResult("失败",false,null,result);
        }else{
            setBaseResult("成功",true,data,result);
        }
    }
}
