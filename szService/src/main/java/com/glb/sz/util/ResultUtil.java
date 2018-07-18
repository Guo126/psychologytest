package com.glb.sz.util;

import com.glb.sz.model.BaseResult;

public class ResultUtil {

    public static <T> BaseResult<T> buildResult(){
        return new BaseResult<>();
    }


    public static <T> void setResult(String message,boolean isSuccess,T data,BaseResult<T> result){
        result.setMessage(message);
        result.setSuccess(isSuccess);
        result.setData(data);
    }

    public static <T> void setResult(T data,BaseResult<T> result){
        if(data == null){
            setResult("失败",false,null,result);
        }else{
            setResult("成功",true,data,result);
        }
    }
}
