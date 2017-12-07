package com.yuan.www.exception;

public class TeacherNotFoundException extends RuntimeException {
	private int id;

	public TeacherNotFoundException(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
