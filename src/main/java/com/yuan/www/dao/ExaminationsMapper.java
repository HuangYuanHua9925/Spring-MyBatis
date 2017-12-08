package com.yuan.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.test.annotation.IfProfileValue;

import com.yuan.www.dao.provider.ExaminationsProvider;
import com.yuan.www.model.Examinations;

public interface ExaminationsMapper {

	@Delete("delete from tb_examinations where id=#{id}")
	int deleteById(@Param("id") Integer id);

	@InsertProvider(type = ExaminationsProvider.class, method = "save")
	@Options(useGeneratedKeys = true, keyColumn = "id")
	int save(Examinations examinations);

	@Select("select * from tb_examinations where id=#{id}")
	Examinations selectById(@Param("id") Integer id);

	@UpdateProvider(type = ExaminationsProvider.class, method = "update")
	int updateByiId(Examinations examinations);

	@Select("select * from tb_examinations order by ${col}")
	@ResultType(com.yuan.www.model.Examinations.class)
	List<Examinations> selectOrderBy(Map<String, Object> map);
}