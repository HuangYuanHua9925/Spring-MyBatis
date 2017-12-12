package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuan.www.dao.ExamineeMapper;

public class TestExaneeMapper {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		ExamineeMapper examineeMapper = context.getBean(ExamineeMapper.class);
		System.out.println(examineeMapper.selectById(1));
		context.close(); 
		
	}

}
