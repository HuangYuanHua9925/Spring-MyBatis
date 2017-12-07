package com.yuan.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.yuan.www.model.Examinations;

public interface ExaminationsMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Examinations record);

	int insertSelective(Examinations record);

	Examinations selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Examinations record);

	int updateByPrimaryKey(Examinations record);

	
	@Select("select * from tb_examinations order by ${name}")
	@ResultType(com.yuan.www.model.Examinations.class)
	List<Examinations> selectById(Map<String, Object> map);
}