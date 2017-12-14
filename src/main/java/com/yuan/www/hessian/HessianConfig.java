package com.yuan.www.hessian;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.yuan.www.dao.ExamineeMapper;

@Configuration
public class HessianConfig {
	@Bean
	public HessianServiceExporter hessianServiceExporter(
			ExamineeMapper examineeMapper) {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(examineeMapper);
		exporter.setServiceInterface(ExamineeMapper.class);
		return exporter;
	}

	@Bean
	public HandlerMapping hessianMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
//		key:url
//		value:HessianServiceExporter的bean id
		mappings.setProperty("/hessian.service", "hessianServiceExporter");
		mapping.setMappings(mappings);
		return mapping;
	}

}
