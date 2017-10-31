package com.zensar.learnappservices.restcontrollers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.zensar.learnappservices.beans.ExamGroupBean;
import com.zensar.learnappservices.services.ExamServicesImpl;

@RestController
@RequestMapping(value="/examgroups",produces=MediaType.APPLICATION_JSON_VALUE)
public class ExamGroupRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamRestController.class);
	@Autowired
	ExamServicesImpl examServices;

	@RequestMapping(value="/dashboardExamGroups/{userId}")
	public ResponseEntity<List<ExamGroupBean>> getExamGroupsForUser(@PathVariable("userId") String userId) throws InterruptedException{
		LOGGER.warn("in getAllExams "+userId);
		List<ExamGroupBean> examBeans= examServices.getExamGroupsForUser(userId);
		return new ResponseEntity<List<ExamGroupBean>>(examBeans,HttpStatus.OK);
	}
	@RequestMapping(value="/{examGroupId}/{examType}")
	public ResponseEntity<ExamBean> getExamFromType(@PathVariable("examGroupId") int examGroupId,@PathVariable("examType") String examType) throws InterruptedException{
		LOGGER.warn("in getExamFromType examGroupId"+examGroupId+" examType "+examType);
		ExamBean examBean= examServices.getExamFromType(examGroupId,examType);
		return new ResponseEntity<ExamBean>(examBean,HttpStatus.OK);
	}

	@RequestMapping(value="/images/{examGroupId}")
	public void getImagesForExamGroups(@PathVariable("examGroupId") int examGroupId,HttpServletResponse response){
		LOGGER.warn("in getImagesForExamGroups "+examGroupId);
		InputStream inputStream = examServices.getImagesForExamGroups(examGroupId);
		response.setContentType("image/jpg");
		try {
			downlaodFile(inputStream,response,examGroupId,".jpg");
		} catch (IOException e) {
		}
	}

	@RequestMapping(value="/{examGroupId}/exams")
	public ResponseEntity<List<ExamBean>> getAllExamsfromExamGroup(@PathVariable("examGroupId") int examGroupId){
		LOGGER.warn("in getAllExamsfromExamGroup Service "+examGroupId);
		return new ResponseEntity<List<ExamBean>>(examServices.getAllExamsfromExamGroup(examGroupId),HttpStatus.OK);
	}

	@RequestMapping(value="/allExamGroups/{userId}")
	public ResponseEntity<List<ExamGroupBean>> getAllExamGroupsForUser(@PathVariable("userId") String userId){
		LOGGER.warn("in getAllExamGroupsForUser "+userId);
		List<ExamGroupBean> examBeans= examServices.getAllExamGroupsForUser(userId);
		return new ResponseEntity<List<ExamGroupBean>>(examBeans,HttpStatus.OK);
	}

	@RequestMapping(value="/subscribeExamGroups")
	public ResponseEntity<Void> subscribeGroup(@RequestParam("examGroupId") int examGroupId,@RequestParam("userId") String userId){
		LOGGER.warn("in subscribeGroup userId"+userId+" examGroupId "+examGroupId);
		boolean status= examServices.subscribeGroup(examGroupId,userId);
		LOGGER.warn("subscribeGroup "+status);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value="/unsubscribeExamGroups")
	public ResponseEntity<Void> unsubscribeGroup(@RequestParam("examGroupId") int examGroupId,@RequestParam("userId") String userId){
		LOGGER.warn("in unsubscribeGroup userId"+userId+" examGroupId "+examGroupId);
		boolean status= examServices.unsubscribeGroup(examGroupId,userId);
		LOGGER.warn("unsubscribeGroup "+status);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private void downlaodFile(InputStream inputStream,HttpServletResponse response,int examGroupId,String type) throws IOException{

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"","imageExamGroup"+"_"+examGroupId+type);
		response.setHeader(headerKey, headerValue);
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}


}
