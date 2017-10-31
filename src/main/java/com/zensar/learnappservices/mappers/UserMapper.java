package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.UserBean;

public class UserMapper implements RowMapper<UserBean>{

	@Override
	public UserBean mapRow(ResultSet rs, int count) throws SQLException {
		return new UserBean(rs.getString("userId"),rs.getString("userName"),rs.getString("status"),rs.getString("userRole"),rs.getLong("totalPerks"),rs.getString("leagueName"));
	}

}
