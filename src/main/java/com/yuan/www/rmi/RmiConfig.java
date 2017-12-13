package com.yuan.www.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.yuan.www.service.TeacherService;

@Configuration
public class RmiConfig {
	
	@Bean
	public RmiServiceExporter rmiServiceExporter(TeacherService teacherService) {

		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setService(teacherService);
		rmiServiceExporter.setServiceName("teacherService");
		rmiServiceExporter.setServiceInterface(TeacherService.class);
		return rmiServiceExporter;
	}
}
