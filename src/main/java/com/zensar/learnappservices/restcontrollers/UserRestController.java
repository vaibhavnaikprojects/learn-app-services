package com.zensar.learnappservices.restcontrollers;

import java.util.List;

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

import com.zensar.learnappservices.beans.EvaluationBean;
import com.zensar.learnappservices.beans.UserBean;
import com.zensar.learnappservices.services.UserServicesImpl;

@RestController
@RequestMapping(value="/users",produces=MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	UserServicesImpl userServices;
	
	@RequestMapping(value="/user")
	public ResponseEntity<UserBean> getUserByCredentials(@RequestParam("userId") String userId,@RequestParam("password") String password){
		LOGGER.warn("in getUserByCredentials"+userId);
		UserBean bean= userServices.getUserByCredentials(userId,password);
		return new ResponseEntity<UserBean>(bean,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{userId}/evaluations")
	public ResponseEntity<List<EvaluationBean>> getEvaluationsOfUser(String userId){
		LOGGER.warn("in getEvaluationsOfUser"+userId);
		List<EvaluationBean> evaluationBeans =userServices.getEvaluationsOfUser(userId);
		if(evaluationBeans!=null)
			return new ResponseEntity<List<EvaluationBean>>(evaluationBeans,HttpStatus.OK);
		else
			return new ResponseEntity<List<EvaluationBean>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{userId}/achievementCount")
	public ResponseEntity<Integer> userAchievementsCount(@PathVariable("userId") String userId){
		LOGGER.warn("in userAchievementsFound"+userId);
		int achievementCount =userServices.getUserAchievementsCount(userId);
		return new ResponseEntity<Integer>(achievementCount,HttpStatus.NOT_FOUND);
	}

}
