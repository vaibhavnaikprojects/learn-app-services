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

import com.zensar.learnappservices.beans.AchievementGroupBean;
import com.zensar.learnappservices.services.AchievementServiceImpl;

@RestController
@RequestMapping(value="/achievements",produces=MediaType.APPLICATION_JSON_VALUE)
public class AchievementRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AchievementRestController.class);
	@Autowired
	AchievementServiceImpl achievementServiceImpl;

	@RequestMapping(value="/{userId}")
	public ResponseEntity<List<AchievementGroupBean>> getUserAchievements(@PathVariable("userId") String userId){
		LOGGER.warn("in getUserAchievements service "+userId);
		List<AchievementGroupBean> achievementGroupBeans= achievementServiceImpl.getUserAchievements(userId);
		return new ResponseEntity<List<AchievementGroupBean>>(achievementGroupBeans,HttpStatus.OK);
	}
	
	@RequestMapping(value="/claimReward")
	public void claimReward(@RequestParam("userId") String userId,@RequestParam("groupName") String groupName){
		LOGGER.warn("in claimReward service "+userId+" groupName "+groupName);
		achievementServiceImpl.claimReward(userId,groupName);
	}

}
