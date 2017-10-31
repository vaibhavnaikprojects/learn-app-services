package com.zensar.learnappservices.beans;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExamGroupBean {
	private int examGroupId;
	private String examGroupName;
	private String examGroupDesc;
	private String examGroupIcon;
	private List<ExamBean> examBeans; 
	public ExamGroupBean(){
	}
	public ExamGroupBean(int examGroupId, String examGroupName,String examGroupDesc) {
		super();
		this.examGroupId = examGroupId;
		this.examGroupName = examGroupName;
		this.examGroupDesc = examGroupDesc;
	}
	public int getExamGroupId() {
		return examGroupId;
	}
	public void setExamGroupId(int examGroupId) {
		this.examGroupId = examGroupId;
	}
	public String getExamGroupName() {
		return examGroupName;
	}
	public void setExamGroupName(String examGroupName) {
		this.examGroupName = examGroupName;
	}
	public String getExamGroupDesc() {
		return examGroupDesc;
	}
	public void setExamGroupDesc(String examGroupDesc) {
		this.examGroupDesc = examGroupDesc;
	}
	public String getExamGroupIcon() {
		return examGroupIcon;
	}
	public void setExamGroupIcon(String examGroupIcon) {
		this.examGroupIcon = examGroupIcon;
	}
	public List<ExamBean> getExamBeans() {
		return examBeans;
	}
	public void setExamBeans(List<ExamBean> examBeans) {
		this.examBeans = examBeans;
	}
	@Override
	public String toString() {
		return "ExamGroupBean [examGroupId=" + examGroupId + ", examGroupName="
				+ examGroupName + ", examGroupDesc=" + examGroupDesc
				+ ", examGroupIcon=" + examGroupIcon + "]";
	}
	
}
