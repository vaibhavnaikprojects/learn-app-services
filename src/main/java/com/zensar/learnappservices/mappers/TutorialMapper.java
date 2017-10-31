package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.TutorialBean;

public class TutorialMapper implements RowMapper<TutorialBean> {

	@Override
	public TutorialBean mapRow(ResultSet rs, int count) throws SQLException {
		TutorialBean bean= new TutorialBean(rs.getInt("tutorialId"),rs.getInt("slideNo"),rs.getString("slideDescription"),rs.getInt("examId"));
		try {
			bean.setImage(Base64.encodeBase64String(IOUtils.toByteArray(rs.getBinaryStream("slideImage"))));
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return bean;
		}
	}
}
