package com.yuan.www.service.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

		return teacherMapper.selectById(id);
	}

	@Override
	public int insert(Teacher teacher) {
		
		return teacherMapper.insert(teacher);
	}

	@Override
	public int update(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.update(teacher);
	}

}
