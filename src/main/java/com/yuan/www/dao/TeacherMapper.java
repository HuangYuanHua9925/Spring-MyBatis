package com.yuan.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yuan.www.dao.provider.TeacherProvider;
import com.yuan.www.model.Teacher;

public interface TeacherMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Teacher record);

	int insertSelective(Teacher record);

	Teacher selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Teacher record);

	int updateByPrimaryKey(Teacher record);

	@Select("select * from tb_teacher")
	List<Teacher> selsectAll();

	@Select("select * from tb_teacher limit #{offset},#{limit}")
	List<Teacher> selectTeachersByLimit(@Param("offset") int offset,
			@Param("limit") int limit);

	@Select("select * from tb_teacher limit #{offset,jdbcType=INTEGER},#{limit}")
	List<Teacher> selectTeachersByLimit2(Map<String, Object> map);

	@DeleteProvider(type = TeacherProvider.class, method = "deleteProvider")
	int deleteTeacher(Teacher teacher);

}