package com.zensar.learnappservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.learnappservices.beans.FeedbackBean;
import com.zensar.learnappservices.daoservices.FeedbackDaoServicesImpl;
import com.zensar.learnappservices.util.MailSender;

@Service
public class FeedbackServiceImpl {
	@Autowired
	MailSender mailSender;
	@Autowired
	FeedbackDaoServicesImpl feedbackDaoServicesImpl;

	public FeedbackBean getUserFeedback(String userId) {
		try {
			return feedbackDaoServicesImpl.getUserFeedback(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addFeedback(FeedbackBean feedbackBean) {
		try {
			if(feedbackBean.getRating()!=0)
				feedbackDaoServicesImpl.addRating(feedbackBean);
			else if(feedbackBean.getFeedback()!=null && !"".equals(feedbackBean.getFeedback()))
				feedbackDaoServicesImpl.addFeedback(feedbackBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
