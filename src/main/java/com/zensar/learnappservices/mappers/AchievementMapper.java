package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.AchievementGroupBean;

public class AchievementMapper implements RowMapper<AchievementGroupBean> {

	@Override
	public AchievementGroupBean mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		return new AchievementGroupBean(rs.getString("groupName"), rs.getString("firstStarText"), rs.getString("secondStarText"), rs.getString("thirdStarText"), rs.getInt("userStarCount"), rs.getInt("statCount"),rs.getString("claimButtonStatus"));
	}

}
