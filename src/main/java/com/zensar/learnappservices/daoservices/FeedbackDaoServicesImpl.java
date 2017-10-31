package com.zensar.learnappservices.daoservices;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.zensar.learnappservices.beans.FeedbackBean;
import com.zensar.learnappservices.mappers.FeedbackMapper;
import com.zensar.learnappservices.util.Queries;

@Repository
public class FeedbackDaoServicesImpl extends JdbcDaoSupport{

	public FeedbackBean getUserFeedback(String userId) {
		try {
			return getJdbcTemplate().queryForObject(Queries.GET_USER_FEEDBACK,new Object[] {userId},new FeedbackMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	public void addRating(FeedbackBean feedbackBean){
		int rowcount=getJdbcTemplate().queryForObject(Queries.FEEDBACK_FOUND,new Object[]{feedbackBean.getUserId()},Integer.class);
		if(rowcount==0)
			getJdbcTemplate().update(Queries.ADD_RATING,new Object[]{feedbackBean.getRating(),feedbackBean.getUserId()});
		else
			getJdbcTemplate().update(Queries.UPDATE_RATING,new Object[]{feedbackBean.getRating(),feedbackBean.getUserId()});
	}
	public void addFeedback(FeedbackBean feedbackBean){
		int rowcount=getJdbcTemplate().queryForObject(Queries.FEEDBACK_FOUND,new Object[]{feedbackBean.getUserId()},Integer.class);
		if(rowcount==0)
			getJdbcTemplate().update(Queries.ADD_FEEDBACK,new Object[]{feedbackBean.getFeedback(),feedbackBean.getUserId()});
		else
			getJdbcTemplate().update(Queries.UPDATE_Feedback,new Object[]{feedbackBean.getFeedback(),feedbackBean.getUserId()});
	}
}
