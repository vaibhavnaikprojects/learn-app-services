package com.zensar.learnappservices.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class ExamBean implements Serializable{
	private static final long serialVersionUID = 602882304767598526L;
	private int examId;
	private String examName;
	private String examDescription;
	private int passingMarks;
	private int maxMarks;
	private String examImage;
	private int perks;
	private List<TutorialBean> tutorialBeans;
	private List<QuestionBean> questions;
	public ExamBean() {
	}
	public ExamBean(int examId, String examName, String examDescription,
			int passingMarks, int maxMarks,int perks) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDescription = examDescription;
		this.passingMarks = passingMarks;
		this.maxMarks = maxMarks;
		this.perks=perks;
	}
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamDescription() {
		return examDescription;
	}
	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
	}
	public int getPassingMarks() {
		return passingMarks;
	}
	public void setPassingMarks(int passingMarks) {
		this.passingMarks = passingMarks;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	public List<QuestionBean> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionBean> questions) {
		this.questions = questions;
	}
	public List<TutorialBean> getTutorialBeans() {
		return tutorialBeans;
	}
	public void setTutorialBeans(List<TutorialBean> tutorialBeans) {
		this.tutorialBeans = tutorialBeans;
	}
	public String getExamImage() {
		return examImage;
	}
	public void setExamImage(String examImage) {
		this.examImage = examImage;
	}
	public int getPerks() {
		return perks;
	}
	public void setPerks(int perks) {
		this.perks = perks;
	}
	@Override
	public String toString() {
		return "ExamBean [examId=" + examId + ", examName=" + examName
				+ ", examDescription=" + examDescription + ", passingMarks="
				+ passingMarks + ", maxMarks=" + maxMarks + ", tutorialBeans="
				+ tutorialBeans + ", questions=" + questions + "]";
	}
	
	
}
