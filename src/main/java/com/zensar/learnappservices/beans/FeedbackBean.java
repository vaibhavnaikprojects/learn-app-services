package com.zensar.learnappservices.beans;

import org.springframework.stereotype.Component;

@Component
public class FeedbackBean {
	private int feedbackId;
	private String feedback;
	private String userId;
	private double rating;
	public FeedbackBean() {
		super();
	}
	
	public FeedbackBean(int feedbackId, String feedback,
			String userId, double rating) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.userId = userId;
		this.rating = rating;
	}

	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FeedbackBean [feedbackId=" + feedbackId + ", feedback="
				+ feedback + ", userId="
				+ userId + ", rating=" + rating + "]";
	}
}
