package com.zensar.learnappservices.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.learnappservices.beans.UserBean;
import com.zensar.learnappservices.services.ExamServicesImpl;
import com.zensar.learnappservices.services.UserServicesImpl;

@Controller
public class ApplicationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	UserServicesImpl userServices;
	
	@Autowired
	ExamServicesImpl examServices;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		LOGGER.warn("Login Mapping ");
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView home(HttpServletRequest request,@RequestParam("userId") String userId,@RequestParam("password") String password) {
		LOGGER.warn("Login Mapping "+userId);
		UserBean userBean=userServices.getUserByCredentials(userId, password);
		request.getSession().setAttribute("user",userBean);
		return new ModelAndView("home","examGroupList",examServices.getAllExamsGroups());
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homeGet(HttpServletRequest request) {
		return new ModelAndView("home","examGroupList",examServices.getAllExamsGroups());
	}
	
	@RequestMapping(value = "/exam", method = RequestMethod.GET)
	public ModelAndView exam() {
		LOGGER.warn("Exam Mapping");
		return new ModelAndView("exam/newExam");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		LOGGER.warn("Logout Mapping");
		request.getSession().invalidate();
		return new ModelAndView("index");
	}
}
