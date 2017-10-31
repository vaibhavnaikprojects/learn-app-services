
package com.zensar.learnappservices.beans;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserBean implements Serializable{
	private static final long serialVersionUID = 907562289332308790L;
	private String userId;
    private String userName;
    private String status;
    private String userRole;
    private long totalPerks;
    private String league;
    private List<EvaluationBean> evaluationBeans;
    public UserBean(){} 
    
	public UserBean(String userId, String userName, String status,
			String userRole, long totalPerks, String league) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.status = status;
		this.userRole = userRole;
		this.totalPerks = totalPerks;
		this.league = league;
	}



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<EvaluationBean> getEvaluationBeans() {
		return evaluationBeans;
	}
	public void setEvaluationBeans(List<EvaluationBean> evaluationBeans) {
		this.evaluationBeans = evaluationBeans;
	}
	public long getTotalPerks() {
		return totalPerks;
	}

	public void setTotalPerks(long totalPerks) {
		this.totalPerks = totalPerks;
	}

	public String getLeague() {
		return league;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName
				+ ", status=" + status + ", totalPerks=" + totalPerks + ", league=" + league + "]";
	}
    
}
