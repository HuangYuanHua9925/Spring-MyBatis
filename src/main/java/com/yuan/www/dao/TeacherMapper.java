package com.yuan.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.yuan.www.dao.provider.TeacherProvider;
import com.yuan.www.model.Teacher;

public interface TeacherMapper {
	@Delete("delete from tb_teacher where id=#{id}")
	int deleteById(@Param("id") Integer id);

	@Select("select * from tb_teacher limit #{offset},#{limit}")
	List<Teacher> selectTeachersByLimit(@Param("offset") int offset,
			@Param("limit") int limit);

	@Select("select * from tb_teacher limit #{offset,jdbcType=INTEGER},#{limit}")
	List<Teacher> selectTeachersByLimit2(Map<String, Object> map);

	@DeleteProvider(type = TeacherProvider.class, method = "deleteProvider")
	int deleteTeacher(Teacher teacher);

	@Select("select  * from tb_teacher where id=#{id}")
	Teacher selectById(@Param("id") Integer id);

	@InsertProvider(type = TeacherProvider.class, method = "insert")
	@Options(useGeneratedKeys = true, keyColumn = "id")
	int insert(Teacher teacher);

	@UpdateProvider(type = TeacherProvider.class, method = "update")
	int update(Teacher teacher);

}