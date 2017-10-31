package com.zensar.learnappservices.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.learnappservices.beans.ExamBean;

public class ExamMapper implements RowMapper<ExamBean> {

	@Override
	public ExamBean mapRow(ResultSet rs, int count) throws SQLException {
		ExamBean bean=new ExamBean(rs.getInt("examId"),rs.getString("examName"),rs.getString("examDescription"),rs.getInt("passingMarks"),rs.getInt("maxMarks"),rs.getInt("perks"));
		/*try {
			InputStream inputStream=rs.getBinaryStream("examImage");
			bean.setExamImage(Base64.encodeBase64String(IOUtils.toByteArray(inputStream)));
			return bean;
		} catch (Exception e) {
			e.printStackTrace();*/
			return bean;
		/*}*/
	}	
}
