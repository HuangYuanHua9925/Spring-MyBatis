package com.yuan.www.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.yuan.www.model.Examinee;

public class ExamineeProvider {
	public String save(final Examinee examinee) {
		return new SQL() {
			{
				INSERT_INTO("tb_examinee");
				if (examinee.getName() != null) {
					VALUES("name", "#{name}");
				}

				if (examinee.getPassword() != null) {
					VALUES("password", "#{password}");
				}

				if (examinee.getStudentId() != null) {
					VALUES("student_id", "#{studentId}");
				}

				if (examinee.getClassNum() != null) {
					VALUES("class_num", "#{calssNum}");
				}

				if (examinee.getAvater() != null) {
					VALUES("avater", "#{avater}");
				}

				if (examinee.getLoginTime() != null) {
					VALUES("login_time", "#{loginTime}");
				}

				if (examinee.getTel() != null) {
					VALUES("tel", "#{tel}");
				}

				if (examinee.getNationality() != null) {
					VALUES("nationality", "#{nationality}");
				}

				if (examinee.getHeight() != null) {
					VALUES("height", "#{height}");
				}

				if (examinee.getWeight() != null) {
					VALUES("weight", "#{weight}");
				}

				if (examinee.getSchool() != null) {
					VALUES("school", "#{school}");
				}

				if (examinee.getSex() != null) {
					VALUES("sex", "#{sex}");
				}
			}
		}.toString();

	}

	public String update(final Examinee examinee) {
		return new SQL() {
			{
				UPDATE("tb_examinee");
				if (examinee.getName() != null) {
					SET("name=#{name}");
				}

				if (examinee.getPassword() != null) {
					SET("password=#{password}");
				}

				if (examinee.getStudentId() != null) {
					SET("student_id=#{studentId}");
				}

				if (examinee.getClassNum() != null) {
					SET("class_num=#{calssNum}");
				}

				if (examinee.getAvater() != null) {
					SET("avater=#{avater}");
				}

				if (examinee.getLoginTime() != null) {
					SET("login_time=#{loginTime}");
				}

				if (examinee.getTel() != null) {
					SET("tel=#{tel}");
				}

				if (examinee.getNationality() != null) {
					SET("nationality=#{nationality}");
				}

				if (examinee.getHeight() != null) {
					SET("height=#{height}");
				}

				if (examinee.getWeight() != null) {
					SET("weight=#{weight}");
				}

				if (examinee.getSchool() != null) {
					SET("school=#{school}");
				}

				if (examinee.getSex() != null) {
					SET("sex=#{sex}");
				}
				WHERE("id=#{id}");
			}
		}.toString();

	}
}
