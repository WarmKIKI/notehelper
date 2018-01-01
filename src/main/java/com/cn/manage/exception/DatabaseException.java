package com.cn.manage.exception;

public class DatabaseException extends BaseException{
    public DatabaseException() {
    }

    public DatabaseException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
