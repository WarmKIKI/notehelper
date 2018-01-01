package com.cn.manage.exception;

public class UserException extends RuntimeException{

private static final long serialVersionUID = 1L;
private String errorCode;
private String errorMessage;


	public UserException() {
		super();
	}

	public UserException(String errorMessage) {
		super(errorMessage);
	}



	public UserException(String errorCode, String errorMessage) {
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
public void setErrorMessage(String Message) {
	this.errorMessage = errorMessage;
}

}
