package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.FeedbackBean;

public class FeedbackMapper implements RowMapper<FeedbackBean> {

	@Override
	public FeedbackBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new FeedbackBean(rs.getInt("feedbackId"),rs.getString("feedback"),rs.getString("userId"),rs.getDouble("rating"));
	}

}
