package com.zensar.learnappservices.beans;

import org.springframework.stereotype.Component;
@Component
public class TutorialBean {
	private int tutorialId;
	private int slideNo;
	private String slideDescription;
	private int examId;
	private String image;
	public TutorialBean() {
		super();
	}
	public TutorialBean(int slideNo, String slideDescription, int examId) {
		super();
		this.slideNo = slideNo;
		this.slideDescription = slideDescription;
		this.examId = examId;
	}
	public TutorialBean(int tutorialId, int slideNo, String slideDescription, int examId) {
		super();
		this.tutorialId = tutorialId;
		this.slideNo = slideNo;
		this.slideDescription = slideDescription;
		this.examId = examId;
	}
	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	public int getSlideNo() {
		return slideNo;
	}
	public void setSlideNo(int slideNo) {
		this.slideNo = slideNo;
	}
	public String getSlideDescription() {
		return slideDescription;
	}
	public void setSlideDescription(String slideDescription) {
		this.slideDescription = slideDescription;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "TutorialBean [tutorialId=" + tutorialId + ", slideNo="
				+ slideNo + ", "+ ", examId=" + examId +"]";
	}
	
	
	
}
