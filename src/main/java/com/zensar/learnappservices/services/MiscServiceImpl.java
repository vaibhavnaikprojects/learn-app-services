package com.zensar.learnappservices.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.learnappservices.beans.ExamBean;
import com.zensar.learnappservices.daoservices.MiscDAOServicesImpl;
import com.zensar.learnappservices.util.MailSender;

@Service
public class MiscServiceImpl {
	@Autowired
	MailSender mailSender;
	@Autowired
	MiscDAOServicesImpl miscDAOServicesImpl;
	
	public void shareApp(String invitePeople, String message, String userId) {
		try {
			List<String> toList=new ArrayList<String>(Arrays.asList(invitePeople.split(",")));
			miscDAOServicesImpl.shareApp(invitePeople, message, userId, toList.size());
			Map<String, Object> inputs=new HashMap<String, Object>();
			inputs.put("message",message);
			inputs.put("invitedBy",userId);
			mailSender.sendMail("shareApp.html", inputs, "Check this new App", toList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ExamBean> getReports(String userId) {
		try {
			return miscDAOServicesImpl.getCompletedExams(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
