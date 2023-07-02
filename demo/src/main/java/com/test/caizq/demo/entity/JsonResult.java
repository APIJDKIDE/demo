package com.test.caizq.demo.entity;

public class JsonResult<T> {
	
	private T data;
	private String code;
	private String msg;
	
	
	public JsonResult() {
		this.code = "200";
		this.msg = "操作成功";
		this.data = null;
	}	
	
	public JsonResult(T data) {
		this.code = "200";
		this.msg = "操作成功";
		this.data = data;
	}
	
	public JsonResult(String code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	public JsonResult(String code, String msg,T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
