package com.zensar.learnappservices.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.learnappservices.beans.ExamBean;
import com.zensar.learnappservices.beans.TutorialBean;
import com.zensar.learnappservices.services.ExamServicesImpl;
import com.zensar.learnappservices.util.FileDownloader;

@Controller
public class ExamController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamController.class);

	@Autowired
	ExamServicesImpl examServices;

	@Autowired
	FileDownloader fileDownloader;

	@RequestMapping(value="/getExam",method=RequestMethod.GET)
	public ModelAndView getExam(@RequestParam("examId") int examId){
		LOGGER.warn("in getExam "+examId);
		ExamBean examBean= examServices.getExam(examId);
		examBean.setQuestions(examServices.getQuestionsForExam(examId));
		ModelAndView view=new ModelAndView("exam/examDetail");
		view.addObject("exam",examBean);
		view.addObject("questionCount",examServices.getQuestionsCount(examId));
		view.addObject("slideCount",examServices.getTutorialCount(examId));
		return view;
	}
	
	@RequestMapping(value="/deleteExam",method=RequestMethod.GET)
	public ModelAndView deleteExam(@RequestParam("examId") int examId){
		LOGGER.warn("in deleteExam "+examId);
		ModelAndView view=new ModelAndView("home");
		if(examServices.deleteExam(examId))
			view.addObject("success","Exam Deleted Successfully");
		else
			view.addObject("message","Exam Deletion failed");
		view.addObject("examGroupList",examServices.getAllExamsGroups());
		return view;
	}

	@RequestMapping(value="/getQuestions",method=RequestMethod.GET)
	public ModelAndView getQuestions(@RequestParam("examId") int examId){
		LOGGER.warn("in getExam "+examId);
		ExamBean examBean=new ExamBean();
		examBean.setExamId(examId);
		examBean.setQuestions(examServices.getQuestionsForExam(examId));
		return new ModelAndView("exam/questionDetail","exam",examBean);
	}

	@RequestMapping(value="/getSlides",method=RequestMethod.GET)
	public ModelAndView getSlides(@RequestParam("examId") int examId){
		LOGGER.warn("in getExam "+examId);
		ExamBean examBean=new ExamBean();
		examBean.setExamId(examId);
		examBean.setTutorialBeans(examServices.getTutorialForExam(examId));
		return new ModelAndView("exam/slideDetail","exam",examBean);
	}

	@RequestMapping(value="/addExam",method=RequestMethod.POST)
	public ModelAndView addExam(@ModelAttribute ExamBean examBean,@RequestParam("examGroupId") int examGroupId,@RequestParam MultipartFile image,HttpServletRequest request){
		int examId=0;
		try {
			examId=examServices.addExam(examBean,examGroupId,image.getInputStream(),(int)image.getSize());	
		} catch (IOException e) {
			LOGGER.warn("addExam ",e);
		}
		LOGGER.warn("in addExam "+examBean);
		System.out.println(examId);
		if(examId>0){
			ModelAndView modelAndView=new ModelAndView("exam/newSlides");
			modelAndView.addObject("examId", examId);
			modelAndView.addObject("success","Exam Created Successfully");
			return modelAndView;
		}
		else
			return new ModelAndView("exam/newExam","message","Exam Creation failed");
	}

	@RequestMapping(value="/newQuestions",method=RequestMethod.GET)
	public ModelAndView newQuestions(HttpServletRequest request,@RequestParam("examId") int examId){
		return new ModelAndView("exam/newQuestions","examId",examId);
	}
	@RequestMapping(value="/newSlides",method=RequestMethod.GET)
	public ModelAndView newSlides(HttpServletRequest request,@RequestParam("examId") int examId){
		return new ModelAndView("exam/newSlides","examId",examId);
	}
	
	@RequestMapping(value="/addQuestions",method=RequestMethod.POST)
	public ModelAndView addQuestions(HttpServletRequest request,@RequestParam("uploadQuestions") MultipartFile uploadQuestions,@RequestParam("examId") int examId){
		try {
			examServices.addQuestions(uploadQuestions.getInputStream(),examId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  getExam(examId);
	}
	@RequestMapping(value="/addSlide",method=RequestMethod.POST)
	public ModelAndView addTutorialSlide(@RequestParam("slideNo") int slideNo,@RequestParam("slideDescription") String slideDescription,@RequestParam("slideImage") MultipartFile slideImage,@RequestParam("slideAudio") MultipartFile slideAudio,@RequestParam("examId") int examId){
		try {
			if(examServices.addTutorial(new TutorialBean(slideNo,slideDescription,examId),slideImage.getInputStream(),(int)slideImage.getSize(),slideAudio.getInputStream(),(int)slideAudio.getSize())){
				return new ModelAndView("exam/newSlides","examId", examId);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getExam(examId);
	}

	@RequestMapping(value="/downloadQuestionsTemplate.html",method=RequestMethod.GET)
	public void downloadPIDTemplate(HttpServletResponse response){
		try{
			ClassPathResource pathResource=new ClassPathResource("/LearnAppQuestionsTemplate.xlsx");
			File templateFile=pathResource.getFile();
			fileDownloader.downloadFile(templateFile, response, templateFile.getName());
		} catch (FileNotFoundException e) {
			LOGGER.error("downloadPIDTemplate ",e);
		} catch (IOException e) {
			LOGGER.error("downloadPIDTemplate ",e);
		}
	}
	
	
}
