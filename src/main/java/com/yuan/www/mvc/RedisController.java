package com.yuan.www.mvc;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

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

	@RequestMapping(value = "/teacher", method = RequestMethod.POST)
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

	/**
	 * @title getTeacherById
	 * @target 目的：
	 * @param id
	 * @return ResponseEntity<Teacher>
	 * @since 2017年12月7日
	 */
	@RequestMapping(value = "/teacher/{id}", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Teacher getTeacherById(@PathVariable("id") int id) {
		Teacher teacher = teacherService.selectByPrimaryKey(id);

		if (teacher == null) {
			throw new TeacherNotFoundException(id);
		}
		return teacher;
	}

	/**
	 * @title teacherNotFound
	 * @target 目的：捕获TeacherNotFoundException异常，进行处理
	 * @param e
	 * @return ResponseEntity<Error>
	 * @since 2017年12月7日
	 */
	@ExceptionHandler(TeacherNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Error teacherNotFound(TeacherNotFoundException e) {
		int id = e.getId();
		Error error = new Error(4, "Teacher[" + id + "] not found");
		return error;
	}

	/**
	 * @title saveTeacher
	 * @target 目的：
	 * @return ResponseEntity<Teacher>
	 * @since 2017年12月7日
	 * 
	 *        consumes="application/json",需要请求的header有Content-Type=
	 *        "application/json"，若没有，则会报415错误。 用于指定处理请求的提交内容
	 * 
	 *        produces：要求请求的header中的Accept包含有指定的类型才能生效 用于指定返回内容的类型
	 */
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "teacherEntity", produces = "application/json")
	public ResponseEntity<Teacher> saveTeacher() {
		HttpHeaders headers = new HttpHeaders();
		URI location = URI.create("http://localhost:8080/teacher");
		headers.setLocation(location);
		Teacher teacher = new Teacher();
		teacher.setName("1");
		teacher.setLoginTime(new Date());
		teacherService.insert(teacher);
		return new ResponseEntity<Teacher>(teacher, headers, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, consumes = "application/json", value = "teacherEntity2", produces = "application/json")
	public ResponseEntity<Teacher> saveTeacher2(UriComponentsBuilder ucb) {

		HttpHeaders headers = new HttpHeaders();
		URI location = ucb.path("/test/").path("teacherEntity2/").build()
				.toUri();
		headers.setLocation(location);
		Teacher teacher = new Teacher();
		teacher.setName("1");
		teacher.setLoginTime(new Date());
		teacherService.insert(teacher);
		return new ResponseEntity<Teacher>(teacher, headers, HttpStatus.CREATED);

	}

	@RequestMapping("/exami")
	@ResponseBody
	// 需要指定使用哪一个缓存
	@Cacheable(value = "redisCache")
	public List<Examinations> getExaminations() {
		Map<String, Object> map = new HashMap<>();
		map.put("col", "score");
		return examinationsMapper.selectOrderBy(map);
	}

	@PutMapping(value = "/putTeacher/{id}", produces = "application/json;charset=utf-8",consumes="application/json")
	@ResponseBody
	public int putTeacher(@PathVariable("id") int id) {
		
		Teacher teacher = teacherService.selectByPrimaryKey(id);
		if (teacher == null) {
			throw new TeacherNotFoundException(id);
		}
		teacher.setLoginTime(new Date());
		
		return teacherService.update(teacher);

	}
}
