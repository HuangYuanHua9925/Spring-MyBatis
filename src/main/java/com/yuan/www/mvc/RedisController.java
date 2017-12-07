package com.yuan.www.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuan.www.dao.ExaminationsMapper;
import com.yuan.www.model.Examinations;
import com.yuan.www.model.Teacher;
import com.yuan.www.service.TeacherService;

@Controller
@RequestMapping("test")
public class RedisController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private ExaminationsMapper examinationsMapper;

	@RequestMapping("teacher")
	@ResponseBody
	// 注意key的赋值方式
	// @Cacheable(value = "redisCache", key = "'teacher_'+#id")
	public Teacher getTeacher(@RequestParam(value = "id") int id) {

		ValueOperations<String, Object> opsForValue = redisTemplate
				.opsForValue();
		Object object = opsForValue.get("frist");
		
			if (object == null) {
				Teacher teacher = teacherService.selectByPrimaryKey(id);
				opsForValue.set("frist", teacher);
				System.out.println(Thread.currentThread().getName()+" 1");
				return teacher;
			}
			System.out.println(Thread.currentThread().getName()+" 2");
			return (Teacher) object;
		

	}

	@RequestMapping("exami")
	@ResponseBody
	// 需要指定使用哪一个缓存
	@Cacheable(value = "redisCache")
	public List<Examinations> getExaminations() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "score");
		return examinationsMapper.selectById(map);
	}
}
