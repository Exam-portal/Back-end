package com.onlineexam.portal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserHistory {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private int testScore;
	
//	@NotNull
	private Date testDate;
	
	@NotNull
	private int userId;
	
	@NotNull
	private int testId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "UserHistory [id=" + id + ", testScore=" + testScore + ", testDate=" + testDate + ", userId=" + userId
				+ ", testId=" + testId + "]";
	}
	
}
