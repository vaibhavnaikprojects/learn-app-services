package com.zensar.learnappservices.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.zensar.learnappservices.beans.EvaluationBean;
import com.zensar.learnappservices.beans.ExamBean;
import com.zensar.learnappservices.beans.ExamGroupBean;
import com.zensar.learnappservices.beans.QuestionBean;
import com.zensar.learnappservices.beans.TutorialBean;
import com.zensar.learnappservices.daoservices.ExamDAOServicesImpl;
import com.zensar.learnappservices.util.MailSender;
@Service
public class ExamServicesImpl {
	
	@Autowired
	MailSender mailSender;
	@Autowired
	ExamDAOServicesImpl examDAOServices;

	public List<ExamGroupBean> getExamGroupsForUser(String userId) {
		try {
			return examDAOServices.getExamGroupsForUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<ExamBean> getAllExamsfromExamGroup(int examGroupId) {
		try {
			return examDAOServices.getAllExamsForExamGroup(examGroupId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ExamBean getExam(int examId) {
		try {
			return examDAOServices.getExam(examId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<TutorialBean> getTutorialForExam(int examId) {
		try {
			return examDAOServices.getTutorialForExam(examId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public InputStream getImageForExamSlide(int examId, int slideNo) {
		try {
			return examDAOServices.getImageForExamSlide(examId, slideNo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public InputStream getAudioForExamSlide(int examId,int slideNo) {
		try {
			return examDAOServices.getAudioForExamSlide(examId, slideNo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<QuestionBean> getQuestionsForExam(int examId) {
		try {
			List<QuestionBean> questionBeans= examDAOServices.getQuestionsForExam(examId);
			Collections.shuffle(questionBeans);
			return questionBeans.subList(0, 10);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateEvaluationForUser(EvaluationBean evaluationBean,String userId){
		try {
			return examDAOServices.updateEvaluationForUser(evaluationBean, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ExamGroupBean> getAllExamGroupsForUser(String userId) {
		try {
			return examDAOServices.getAllExamGroupsForUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean subscribeGroup(int examGroupId,String userId){
		try {
			ExamGroupBean examGroupBean= examDAOServices.subscribeExamGroup(examGroupId, userId);
			if(examGroupBean!=null){
				Map<String, Object> inputs=new HashMap<String, Object>();
				inputs.put("examGroupName", examGroupBean.getExamGroupName());
				List<String> toList=new ArrayList<String>();
				toList.add(userId);
				mailSender.sendMail("subscribeExamGroup.html", inputs, "You have subscribed to "+examGroupBean.getExamGroupName(),toList);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean unsubscribeGroup(int examGroupId,String userId){
		try {
			ExamGroupBean examGroupBean= examDAOServices.unsubscribeExamGroup(examGroupId, userId);
			if(examGroupBean!=null){
				Map<String, Object> inputs=new HashMap<String, Object>();
				inputs.put("examGroupName", examGroupBean.getExamGroupName());
				List<String> toList=new ArrayList<String>();
				toList.add(userId);
				mailSender.sendMail("subscribeExamGroup.html", inputs, "You have unsubscribed to "+examGroupBean.getExamGroupName(),toList);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//application
	public List<ExamGroupBean> getAllExamsGroups(){
		try {
			return examDAOServices.getAllExamsGroups();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ExamBean> getAllExamsForExamGroup(int examGroupId){
		try {
			return examDAOServices.getAllExamsForExamGroup(examGroupId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getQuestionsCount(int examId) {
		try {
			return examDAOServices.getQuestionsCount(examId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getTutorialCount(int examId) {
		try {
			return examDAOServices.getTutorialCount(examId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int addExamGroup(ExamGroupBean examGroupBean,InputStream examGroupIcon,int imageSize){
		try {
			return examDAOServices.addExamGroup(examGroupBean, examGroupIcon, imageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int addExam(ExamBean examBean,int examGroupId,InputStream examImage,int imageSize){
		try {
			return examDAOServices.addExam(examBean,examGroupId,examImage,imageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean addTutorial(TutorialBean tutorialBean,InputStream slideImage,int slideSize,InputStream slideAudio,int audioSize){
		try {
			System.out.println(tutorialBean);
			if(examDAOServices.addTutorial(tutorialBean,slideImage,slideSize,slideAudio,audioSize))	return true;
		} catch (DataAccessException | IOException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean addQuestions(InputStream questionStream ,int examId){
		Workbook workbook;
		try {
			workbook = new XSSFWorkbook(questionStream);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		iterator.next();
		iterator.next();
		List<QuestionBean> questionBeans=new ArrayList<QuestionBean>();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			QuestionBean questionBean=new QuestionBean();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			cellIterator.next();
			int currentCell=0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (currentCell) {
				case 0:
					questionBean.setQuestion(cell.getStringCellValue().trim());						
					break;
				case 1:
					if(Cell.CELL_TYPE_STRING==cell.getCellType())
						questionBean.setOption1(cell.getStringCellValue().trim());	
					else if(Cell.CELL_TYPE_BOOLEAN==cell.getCellType()){
						if(cell.getBooleanCellValue())	questionBean.setOption1("TRUE");
						else	questionBean.setOption1("FALSE");
					}
					break;
				case 2:
					if(Cell.CELL_TYPE_STRING==cell.getCellType())
						questionBean.setOption2(cell.getStringCellValue().trim());	
					else if(Cell.CELL_TYPE_BOOLEAN==cell.getCellType()){
						if(cell.getBooleanCellValue())	questionBean.setOption2("TRUE");
						else	questionBean.setOption2("FALSE");
					}
					break;
				case 3:
					questionBean.setOption3(cell.getStringCellValue().trim());						
					break;
				case 4:
					questionBean.setOption4(cell.getStringCellValue().trim());						
					break;
				case 5:
					if(Cell.CELL_TYPE_STRING==cell.getCellType())
						questionBean.setCorrectAnswer(cell.getStringCellValue().trim());	
					else if(Cell.CELL_TYPE_BOOLEAN==cell.getCellType()){
						if(cell.getBooleanCellValue())	questionBean.setCorrectAnswer("TRUE");
						else	questionBean.setCorrectAnswer("FALSE");
					}						
					break;
				default:
					break;
				}
				currentCell++;
			}
			questionBeans.add(questionBean);
		}
		System.out.println(questionBeans);
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(examDAOServices.addQuestions(questionBeans, examId))	return true;
		return false;
	}

	public boolean deleteExam(int examId) {
		try {
			if(examDAOServices.deleteExam(examId))	return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public InputStream getImagesForExamGroups(int examGroupId) {
		try {
			return examDAOServices.getImagesForExamGroups(examGroupId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public InputStream getExamImage(int examId) {
		try {
			return examDAOServices.getExamImage(examId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ExamBean> getPendingExam(String userId) {
		try {
			return examDAOServices.getPendingExam(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ExamBean getExamFromType(int examGroupId, String examType) {
		try {
			return examDAOServices.getExamFromType(examGroupId,examType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
