package com.zensar.learnappservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.learnappservices.beans.EvaluationBean;
import com.zensar.learnappservices.beans.UserBean;
import com.zensar.learnappservices.daoservices.UserDAOServicesImpl;

@Service
public class UserServicesImpl {
	
	@Autowired
	UserDAOServicesImpl userDAOServices;

	public UserBean getUserByCredentials(String userId, String password) {
		try {
			return userDAOServices.getUserFromCredentials(userId, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<EvaluationBean> getEvaluationsOfUser(String userId) {
		try {
			return userDAOServices.getEvaluationsAsPerUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getUserAchievementsCount(String userId) {
		try {
			return userDAOServices.getUserAchievementsCount(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
