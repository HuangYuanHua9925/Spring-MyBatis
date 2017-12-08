package com.yuan.www.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.yuan.www.dao.provider.ExamineeProvider;
import com.yuan.www.model.Examinee;

public interface ExamineeMapper {
	
	@Delete("delete from tb_examinee where id=#{id}")
	int deleteByPrimaryKey(@Param("id") Integer id);

	@InsertProvider(type = ExamineeProvider.class, method = "save")
	@Options(useGeneratedKeys = true, keyColumn = "id")
	int save(Examinee examinee);

	@Select("select * from tb_examinee where id=#{id}")
	Examinee selectById(@Param("id") Integer id);

	@UpdateProvider(type = ExamineeProvider.class, method = "update")
	int update(Examinee examinee);
}