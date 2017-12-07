package com.yuan.www.exception;

public class Error {
	private int code;
	private String messge;
	public int getCode() {
		return code;
	}
	public Error(int code, String messge) {
		super();
		this.code = code;
		this.messge = messge;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessge() {
		return messge;
	}
	public void setMessge(String messge) {
		this.messge = messge;
	}
}
