package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.QuestionBean;

public class QuestionMapper implements RowMapper<QuestionBean> {

	@Override
	public QuestionBean mapRow(ResultSet rs, int count) throws SQLException {
		return new QuestionBean(rs.getInt("questionId"), rs.getString("question"), rs.getString("option1"), rs.getString("option2"), rs.getString("option3"), rs.getString("option4"), rs.getString("correctAnswer"));
	}
}
