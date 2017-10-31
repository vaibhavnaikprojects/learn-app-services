package com.zensar.learnappservices.mappers;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ImageMapper implements RowMapper<InputStream> {
	@Override
	public InputStream mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getBinaryStream("slideImage");
	}
}
