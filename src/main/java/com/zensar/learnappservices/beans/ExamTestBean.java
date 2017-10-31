package com.zensar.learnappservices.beans;

import org.springframework.stereotype.Component;

@Component
public class ExamTestBean {
	private int examId;
	private String userId;
	private int questionCount;
	private boolean answer;
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public boolean getAnswer() {
		return answer;
	}
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "ExamTestBean [examId=" + examId + ", userId=" + userId
				+ ", questionCount=" + questionCount + ", answer=" + answer
				+ "]";
	}
	
	
	
}
