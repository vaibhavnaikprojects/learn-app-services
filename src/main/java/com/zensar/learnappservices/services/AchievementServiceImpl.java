package com.zensar.learnappservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.learnappservices.beans.AchievementGroupBean;
import com.zensar.learnappservices.daoservices.AchievementDAOServicesImpl;
import com.zensar.learnappservices.util.MailSender;

@Service
public class AchievementServiceImpl {

	@Autowired
	MailSender mailSender;
	@Autowired
	AchievementDAOServicesImpl achievementDAOServicesImpl;

	public List<AchievementGroupBean> getUserAchievements(String userId) {
		try {
			return achievementDAOServicesImpl.getUserAchievements(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void claimReward(String userId, String groupName) {
		try {
			achievementDAOServicesImpl.claimAchievement(userId,groupName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
