package com.yuan.www.jaxws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class JaxwsConfig {
	@Bean
	public SimpleJaxWsServiceExporter jaxWsExporter(){
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://127.0.0.1:8080/services/");
		return exporter;
	}
}
