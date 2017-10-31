package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.ExamBean;

public class NoImageExamMapper implements RowMapper<ExamBean> {
	@Override
	public ExamBean mapRow(ResultSet rs, int count) throws SQLException {
		return new ExamBean(rs.getInt("examId"),rs.getString("examName"),rs.getString("examDescription"),rs.getInt("passingMarks"),rs.getInt("maxMarks"),rs.getInt("perks"));
	}	
}
