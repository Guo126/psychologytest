package com.glb.sz.model;

public class ModifyResult {
    private String message;
    private boolean isSuccess;

    public ModifyResult(){

    }

    public ModifyResult(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
