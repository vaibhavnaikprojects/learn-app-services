package com.zensar.learnappservices.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class EvaluationBean implements Serializable{
	private static final long serialVersionUID = -3881426794269122051L;
	private int evaluationId;
	private int examId;
	private String examName;
	private String status;
	private int userMarks;
	private int questionsAttempted;
	private int userPerks;
	public EvaluationBean(){}
	
	public EvaluationBean(int evaluationId, int examId, String examName,String status,
			int userMarks, int questionsAttempted,int userPerks) {
		super();
		this.evaluationId = evaluationId;
		this.examId = examId;
		this.examName = examName;
		this.status = status;
		this.userMarks = userMarks;
		this.questionsAttempted = questionsAttempted;
		this.userPerks=userPerks;
	}

	public int getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserMarks() {
		return userMarks;
	}
	public void setUserMarks(int userMarks) {
		this.userMarks = userMarks;
	}
	public int getQuestionsAttempted() {
		return questionsAttempted;
	}
	public void setQuestionsAttempted(int questionsAttempted) {
		this.questionsAttempted = questionsAttempted;
	}
	public int getUserPerks() {
		return userPerks;
	}
	public void setUserPerks(int userPerks) {
		this.userPerks = userPerks;
	}
	@Override
	public String toString() {
		return "EvaluationBean [evaluationId=" + evaluationId + ", examId="
				+ examId + ", examName=" + examName + ", status=" + status
				+ ", userMarks=" + userMarks + ", questionsAttempted="
				+ questionsAttempted + ", userPerks=" + userPerks + "]";
	}
}
