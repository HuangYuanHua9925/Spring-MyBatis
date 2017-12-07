package com.yuan.www.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.www.dao.TeacherMapper;
import com.yuan.www.model.Teacher;
import com.yuan.www.service.TeacherService;

@Transactional()
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	SqlSessionFactory sessionFactory;

	public Teacher selectByPrimaryKey(int id) {

		SqlSession session = sessionFactory.openSession();
		/*
		 * Examinee examinee = new Examinee(); examinee.setName("张三");
		 * examinee.setPassword("123456");
		 * session.insert("com.yuan.www.dao.ExamineeMapper.insertSelective",
		 * examinee); session.commit();
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		Integer i = new Integer(1);
		map = session.selectMap(
				"com.yuan.www.dao.ExamineeMapper.selectByPrimaryKey", i, "sex");
		System.out.println(map.size());
		for (String key : map.keySet()) {
			System.out.println("key= " + key + " and value= " + map.get(key));
		}

		session.close();

		return teacherMapper.selectByPrimaryKey(id);
	}
}
