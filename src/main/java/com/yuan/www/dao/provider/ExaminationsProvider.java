package com.yuan.www.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.yuan.www.model.Examinations;

public class ExaminationsProvider {

	public String save(final Examinations examinations) {
		return new SQL() {
			{
				INSERT_INTO("tb_examinations");

				if (examinations.getAnswers() != null) {
					VALUES("answers", "#{answers}");
				}
				if (examinations.getStudentId() != null) {
					VALUES("student_id", "#{studentId}");
				}
				if (examinations.getScore() != null) {
					VALUES("score", "#{score}");
				}
				if (examinations.getQuestions() != null) {
					VALUES("questions", "#{questions}");
				}
				if (examinations.getStartExaminationTime() != null) {
					VALUES("start_examination_time", "#{startExaminationTime}");
				}
				if (examinations.getEndExaminationTime() != null) {
					VALUES("end_examination_time", "#{endExaminationTime}");
				}
			}
		}.toString();
	}

	public String update(final Examinations examinations) {
		return new SQL() {
			{
				UPDATE("tb_examinations");
				if (examinations.getAnswers() != null) {
					SET("answers=#{answers}");
				}
				if (examinations.getStudentId() != null) {
					SET("student_id=#{studentId}");
				}
				if (examinations.getScore() != null) {
					SET("score=#{score}");
				}
				if (examinations.getQuestions() != null) {
					SET("questions=#{questions}");
				}
				if (examinations.getStartExaminationTime() != null) {
					SET("start_examination_time=#{startExaminationTime}");
				}
				if (examinations.getEndExaminationTime() != null) {
					SET("end_examination_time=#{endExaminationTime}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
