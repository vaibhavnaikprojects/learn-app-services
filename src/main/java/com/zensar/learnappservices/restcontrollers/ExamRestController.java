package com.zensar.learnappservices.restcontrollers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.learnappservices.beans.EvaluationBean;
import com.zensar.learnappservices.beans.ExamBean;
import com.zensar.learnappservices.beans.QuestionBean;
import com.zensar.learnappservices.beans.TutorialBean;
import com.zensar.learnappservices.services.ExamServicesImpl;

@RestController
@RequestMapping(value="/exams",produces=MediaType.APPLICATION_JSON_VALUE)
public class ExamRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamRestController.class);
	@Autowired
	ExamServicesImpl examServices;
	
	@RequestMapping(value="/{examId}")
	public ResponseEntity<ExamBean> getExam(@PathVariable("examId") int examId){
		LOGGER.warn("in getExam Service "+examId);
		return new ResponseEntity<ExamBean>(examServices.getExam(examId),HttpStatus.OK);
	}

	@RequestMapping(value="/{examId}/tutorial")
	public ResponseEntity<List<TutorialBean>> getTutorialForExam(@PathVariable("examId") int examId){
		LOGGER.warn("in getTutorialForExam Service "+examId);
		List<TutorialBean> tutorialBeansOriginal= examServices.getTutorialForExam(examId);
		List<TutorialBean> newTutorialBeans=new ArrayList<TutorialBean>();
		for (TutorialBean tutorialBean : tutorialBeansOriginal) {
			tutorialBean.setImage("");
			newTutorialBeans.add(tutorialBean);
		}
		return new ResponseEntity<List<TutorialBean>>(newTutorialBeans,HttpStatus.OK);
	}
	
	@RequestMapping(value="/pendingExams/{userId}")
	public ResponseEntity<List<ExamBean>> getPendingExam(@PathVariable("userId") String userId){
		LOGGER.warn("in getPendingExam Service "+userId);
		List<ExamBean> examBeans= examServices.getPendingExam(userId);
		return new ResponseEntity<List<ExamBean>>(examBeans,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getExamImage/{examId}", method = RequestMethod.GET)
	public void getExamImage(@PathVariable("examId")int examId,HttpServletResponse response) {
		LOGGER.warn("in getExamImage Service examId"+examId);
		try {
			InputStream inputStream = examServices.getExamImage(examId);
			response.setContentType("image/jpg");
			downlaodFile(inputStream,response,examId+"","",".jpg");
		} catch (NumberFormatException |IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public void getImageFile(@RequestParam("examId")String examId,@RequestParam("slideNo")String slideNo,HttpServletResponse response) {
		LOGGER.warn("in getImageFile Service examId"+examId+" Slide "+slideNo);
		try {
			InputStream inputStream = examServices.getImageForExamSlide(Integer.parseInt(examId),Integer.parseInt(slideNo));
			response.setContentType("image/jpg");
			downlaodFile(inputStream,response,examId,slideNo,".jpg");
		} catch (NumberFormatException |IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getAudio", method = RequestMethod.GET)
	public void getAudioFile(@RequestParam("examId")String examId,@RequestParam("slideNo")String slideNo,HttpServletResponse response) {
		LOGGER.warn("in getAudioFile Service examId"+examId+" Slide "+slideNo);
		try {
			InputStream inputStream = examServices.getAudioForExamSlide(Integer.parseInt(examId),Integer.parseInt(slideNo));
			response.setContentType("audio/mpeg");
			downlaodFile(inputStream,response,examId,slideNo,".mp3");
		} catch (NumberFormatException |IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/{examId}/questions")
	public ResponseEntity<List<QuestionBean>> getQuestionsForExam(@PathVariable("examId") int examId){
		LOGGER.warn("in getAllExamsfromExamGroup Service "+examId);
		return new ResponseEntity<List<QuestionBean>>(examServices.getQuestionsForExam(examId),HttpStatus.OK);
	}

	@RequestMapping(value="/{userId}/evaluateUser")
	public ResponseEntity<Void> evaluateUser(@PathVariable("userId") String userId,@RequestBody EvaluationBean evaluationBean){
		LOGGER.warn("in updateEvaluationForUser Service userId "+userId+" evaluationBean "+evaluationBean);
		examServices.updateEvaluationForUser(evaluationBean,userId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
	private void downlaodFile(InputStream inputStream,HttpServletResponse response,String examId,String slideNo,String type) throws IOException{
		
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"","audio"+"_"+examId+"_"+slideNo+type);
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
