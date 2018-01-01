package com.cn.manage.exception;

public class BaseException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public BaseException() {
        super();
    }

    public BaseException(String errorMessage) {
        super(errorMessage);
    }



    public BaseException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
