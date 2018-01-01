package com.cn.manage.utils;

import java.util.Map;

public class ResponseEntity {
	public ResponseEntity() {
	}

	public ResponseEntity(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public synchronized ResponseEntity setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public synchronized ResponseEntity setMessage(String message) {
		this.message = message;
		return this;
	}

	@SuppressWarnings("rawtypes")
	public Map getResult() {
		return result;
	}

	@SuppressWarnings("rawtypes")
	public synchronized ResponseEntity setResult(Map result) {
		this.result = result;
		return this;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private String status;

	private String message;
	@SuppressWarnings("rawtypes")
	private Map result;
	//数据体，保存jwf，用于token认证
	public Object data;
}

