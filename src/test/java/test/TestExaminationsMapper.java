package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuan.www.dao.ExaminationsMapper;
import com.yuan.www.model.Examinations;

public class TestExaminationsMapper {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		ExaminationsMapper examinationsMapper = context
				.getBean(ExaminationsMapper.class);
		Examinations examinations = new Examinations();
		examinations.setScore(20);
		examinationsMapper.save(examinations);
		examinationsMapper.selectById(1);
		examinationsMapper.deleteById(1);
		context.close();
	}

}
