package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.ExamGroupBean;

public class ExamGroupMapper implements RowMapper<ExamGroupBean>{

	@Override
	public ExamGroupBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExamGroupBean bean= new ExamGroupBean(rs.getInt("examGroupId"),rs.getString("examGroupName"),rs.getString("examGroupDesc"));
		try {
			//InputStream inputStream=rs.getBinaryStream("examGroupIcon");
			//bean.setExamGroupIcon(Base64.encodeBase64String(IOUtils.toByteArray(inputStream)));
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return bean;
		}
	}

}
