package com.yuan.www.dao;

import java.util.List;
import java.util.Map;

import com.yuan.www.model.Examinee;

public interface ExamineeMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Examinee record);

	int insertSelective(Examinee record);

	Examinee selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Examinee record);

	int updateByPrimaryKey(Examinee record);

	List<Examinee> selectAll(Map<String, Object> map);
}