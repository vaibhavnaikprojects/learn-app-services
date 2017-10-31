package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.EvaluationBean;

public class EvaluationMapper implements RowMapper<EvaluationBean>{

	@Override
	public EvaluationBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new EvaluationBean(rs.getInt("evaluationId"), rs.getInt("examId"), rs.getString("examName"), rs.getString("status"), rs.getInt("userMarks"), rs.getInt("questionsAttempted"),rs.getInt("userPerks"));
	}

}
