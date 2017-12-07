package com.yuan.www.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.yuan.www.model.Teacher;

public class TeacherProvider {
	public String deleteProvider(final Teacher teacher) {
		return new SQL() {
			{
				DELETE_FROM("tb_teacher");
				
				if (teacher.getId() != null) {
					WHERE("id=#{id}");
				}
				
				if(teacher.getHeight()!=null){
					WHERE("height=#{height}");
				}

			}

		}.toString();
	}
}
