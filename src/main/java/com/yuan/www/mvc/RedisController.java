package com.yuan.www.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuan.www.dao.ExaminationsMapper;
import com.yuan.www.exception.TeacherNotFoundException;
import com.yuan.www.exception.Error;
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

	@RequestMapping(value="/teacher",method=RequestMethod.POST)
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
			System.out.println(Thread.currentThread().getName() + " 1");
			return teacher;
		}
		System.out.println(Thread.currentThread().getName() + " 2");
		return (Teacher) object;
	}

	@RequestMapping("/teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") int id) {
		
		Teacher teacher = teacherService.selectByPrimaryKey(id);
		if (teacher == null) {
			throw new TeacherNotFoundException(id);
		}

		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}
	
	/**
	 * @title teacherNotFound
	 * @target 目的：捕获TeacherNotFoundException异常，进行处理
	 * @param e
	 * @return ResponseEntity<Error>
	 * @since 2017年12月7日
	 */
	@ExceptionHandler(TeacherNotFoundException.class)
	public ResponseEntity<Error> teacherNotFound(TeacherNotFoundException e){
		int id = e.getId();
		Error error=new Error(4,"Teacher["+id+"] not found");
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
		
	}
	@RequestMapping("/exami")
	@ResponseBody
	// 需要指定使用哪一个缓存
	@Cacheable(value = "redisCache")
	public List<Examinations> getExaminations() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "score");
		return examinationsMapper.selectById(map);
	}
}
