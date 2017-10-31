package com.zensar.learnappservices.beans;

import java.util.ArrayList;
import java.util.List;

public class AchievementGroupBean {
	private String groupName;
	private String firstStarText;
	private String secondStarText;
	private String thirdStarText;
	private int userStarCount;
	private int statCount;
	private String claimButtonStatus;
	public AchievementGroupBean() {
		super();
	}
	public AchievementGroupBean(String groupName, String firstStarText,
			String secondStarText, String thirdStarText, int userStarCount,int statCount,String claimButtonStatus) {
		super();
		this.groupName = groupName;
		this.firstStarText = firstStarText;
		this.secondStarText = secondStarText;
		this.thirdStarText = thirdStarText;
		this.userStarCount = userStarCount;
		this.statCount=statCount;
		this.claimButtonStatus=claimButtonStatus;
	}
	
	public static List<AchievementGroupBean> getAchievements(){
		List<AchievementGroupBean> achievementGroupBeans=new ArrayList<AchievementGroupBean>();
		achievementGroupBeans.add(new AchievementGroupBean("Good Better Best", "Get in Primary league", "Get in Undergrad league", "Get in Doctorate league", 0,0,"false"));
		achievementGroupBeans.add(new AchievementGroupBean("Series and Sequence", "3 exams in a row", "5 exams in a row", "10 exams in a row", 0,0,"false"));
		achievementGroupBeans.add(new AchievementGroupBean("Veteran Player", "advance level in 3 exam groups", "advance level in 4 exam groups", "advance level in 5 exam groups", 0,0,"false"));
		achievementGroupBeans.add(new AchievementGroupBean("I am the best", "win 5 battles in compete mode", "win 10 battles in compete mode", "win 15 battles in compete mode", 0,0,"false"));
		achievementGroupBeans.add(new AchievementGroupBean("Sharing is caring", "share app to 3 associates", "share app to 5 associates", "share app to 10 associates", 0,0,"false"));
		return achievementGroupBeans;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getFirstStarText() {
		return firstStarText;
	}
	public void setFirstStarText(String firstStarText) {
		this.firstStarText = firstStarText;
	}
	public String getSecondStarText() {
		return secondStarText;
	}
	public void setSecondStarText(String secondStarText) {
		this.secondStarText = secondStarText;
	}
	public String getThirdStarText() {
		return thirdStarText;
	}
	public void setThirdStarText(String thirdStarText) {
		this.thirdStarText = thirdStarText;
	}
	public int getUserStarCount() {
		return userStarCount;
	}
	public void setUserStarCount(int userStarCount) {
		this.userStarCount = userStarCount;
	}
	public int getStatCount() {
		return statCount;
	}
	public void setStatCount(int statCount) {
		this.statCount = statCount;
	}
	public String getClaimButtonStatus() {
		return claimButtonStatus;
	}

	public void setClaimButtonStatus(String claimButtonStatus) {
		this.claimButtonStatus = claimButtonStatus;
	}
	@Override
	public String toString() {
		return "AchievementGroupBean [groupName=" + groupName
				+ ", firstStarText=" + firstStarText + ", secondStarText="
				+ secondStarText + ", thirdStarText=" + thirdStarText
				+ ", userStarCount=" + userStarCount + ", statCount="
				+ statCount + "]";
	}
}
