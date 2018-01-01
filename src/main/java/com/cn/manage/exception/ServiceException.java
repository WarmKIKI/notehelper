package com.cn.manage.exception;

public class ServiceException extends BaseException{
    public ServiceException() {
    }

    public ServiceException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
