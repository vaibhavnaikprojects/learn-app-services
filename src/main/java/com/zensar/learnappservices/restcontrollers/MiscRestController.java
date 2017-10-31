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

import com.zensar.learnappservices.beans.ExamBean;
import com.zensar.learnappservices.services.MiscServiceImpl;

@RestController
@RequestMapping(value="/misc",produces=MediaType.APPLICATION_JSON_VALUE)
public class MiscRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MiscRestController.class);
	@Autowired
	MiscServiceImpl miscServiceImpl;

	@RequestMapping(value="/shareApp")
	public void shareApp(@RequestParam("invitePeople") String invitePeople,@RequestParam("message") String message,@RequestParam("userId") String userId){
		LOGGER.warn("in shareApp service  invitePeople "+invitePeople+" userId "+userId+" message "+message);
		miscServiceImpl.shareApp(invitePeople,message,userId);
	}
	
	@RequestMapping(value="/getReports/{userId}")
	public ResponseEntity<List<ExamBean>> getReports(@PathVariable("userId") String userId){
		LOGGER.warn("in getReports service userId "+userId);
		List<ExamBean> examBeans=miscServiceImpl.getReports(userId);
		return new ResponseEntity<List<ExamBean>>(examBeans,HttpStatus.OK);
	}
}
