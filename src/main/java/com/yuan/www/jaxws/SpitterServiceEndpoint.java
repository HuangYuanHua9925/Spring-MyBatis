package com.yuan.www.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuan.www.model.Teacher;
import com.yuan.www.service.TeacherService;

@Component
@WebService(serviceName="SpitterService",targetNamespace="http://service.www.yuan.com/")
public class SpitterServiceEndpoint {
	@Autowired
	TeacherService teacherService;
	@WebMethod
	public Teacher show(){
		return (teacherService.selectByPrimaryKey(1));
	}
	
}
