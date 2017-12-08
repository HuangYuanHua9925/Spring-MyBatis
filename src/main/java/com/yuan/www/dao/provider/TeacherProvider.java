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

				if (teacher.getHeight() != null) {
					WHERE("height=#{height}");
				}

			}

		}.toString();
	}

	public String insert(final Teacher teacher) {
		return new SQL() {
			{
				INSERT_INTO("tb_teacher");
				if (teacher.getName() != null) {
					VALUES("name", "#{name}");
				}

				if (teacher.getPassword() != null) {
					VALUES("password", "#{password}");
				}
				if (teacher.getPosition() != null) {
					VALUES("position", "#{position}");
				}

				if (teacher.getAvater() != null) {
					VALUES("avater", "#{avater}");
				}

				if (teacher.getLoginTime() != null) {
					VALUES("login_time", "#{loginTime}");
				}

				if (teacher.getTel() != null) {
					VALUES("tel", "#{tel}");
				}

				if (teacher.getNationality() != null) {
					VALUES("nationality", "#{nationality}");
				}

				if (teacher.getHeight() != null) {
					VALUES("height", "#{height}");
				}

				if (teacher.getWeight() != null) {
					VALUES("weight", "#{weight}");
				}

				if (teacher.getSchool() != null) {
					VALUES("school", "#{school}");
				}

				if (teacher.getSex() != null) {
					VALUES("sex", "#{sex}");
				}
			}

		}.toString();
	}

	public String update(final Teacher teacher) {
		return new SQL() {
			{
				UPDATE("tb_teacher");
				if (teacher.getName() != null) {
					SET("name=#{name}");
				}

				if (teacher.getPassword() != null) {
					SET("password=#{password}");
				}

				if (teacher.getPosition() != null) {
					SET("position=#{position}");
				}

				if (teacher.getAvater() != null) {
					SET("avater=#{avater}");
				}

				if (teacher.getLoginTime() != null) {
					SET("login_time=#{loginTime}");
				}

				if (teacher.getTel() != null) {
					SET("tel=#{tel}");
				}

				if (teacher.getNationality() != null) {
					SET("nationality=#{nationality}");
				}

				if (teacher.getHeight() != null) {
					SET("height=#{height}");
				}

				if (teacher.getWeight() != null) {
					SET("weight=#{weight}");
				}

				if (teacher.getSchool() != null) {
					SET("school=#{school}");
				}

				if (teacher.getSex() != null) {
					SET("sex=#{sex}");
				}
			}

		}.toString();
	}
}
