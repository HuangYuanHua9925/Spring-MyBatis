package com.yuan.www.httpinvoker;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.yuan.www.dao.ExaminationsMapper;

@Configuration
public class HttpInvokerConfig {
	@Bean
	public HttpInvokerServiceExporter httpInvokerService(
			ExaminationsMapper examinationsMapper) {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(examinationsMapper);
		exporter.setServiceInterface(ExaminationsMapper.class);
		return exporter;
	}

	@Bean
	public HandlerMapping httpInvakerHandelerMapping() {
		SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
//		key:url
//		value:HttpInvokerServiceExporter的bean id
		mappings.setProperty("/httpInvokerService", "httpInvokerService");
		handlerMapping.setMappings(mappings);
		return handlerMapping;
	}
}
