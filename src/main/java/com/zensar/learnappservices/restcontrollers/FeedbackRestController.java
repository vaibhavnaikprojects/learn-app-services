package com.zensar.learnappservices.restcontrollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.learnappservices.beans.FeedbackBean;
import com.zensar.learnappservices.services.FeedbackServiceImpl;

@RestController
@RequestMapping(value="/feedback",produces=MediaType.APPLICATION_JSON_VALUE)
public class FeedbackRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackRestController.class);
	
	@Autowired
	FeedbackServiceImpl feedbackServiceImpl;
	
	@RequestMapping(value="/{userId}")
	public ResponseEntity<FeedbackBean> getUserFeedback(@PathVariable("userId") String userId){
		LOGGER.warn("in getUserFeedback"+userId);
		FeedbackBean feedbackBean= feedbackServiceImpl.getUserFeedback(userId);
		return new ResponseEntity<FeedbackBean>(feedbackBean,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addRating")
	public void addRating(@RequestParam("userId") String userId,@RequestParam("rating") double rating){
		LOGGER.warn("in addRating service userId "+userId+" rating "+rating);
		FeedbackBean bean=new FeedbackBean();
		bean.setUserId(userId);
		bean.setRating(rating);
		feedbackServiceImpl.addFeedback(bean);
	}
	@RequestMapping(value="/addFeedback")
	public void addFeedback(@RequestParam("userId") String userId,@RequestParam("feedback") String feedback){
		LOGGER.warn("in addFeedback service userId "+userId+" feedback "+feedback);
		FeedbackBean bean=new FeedbackBean();
		bean.setUserId(userId);
		bean.setFeedback(feedback);
		feedbackServiceImpl.addFeedback(bean);
	}
}
