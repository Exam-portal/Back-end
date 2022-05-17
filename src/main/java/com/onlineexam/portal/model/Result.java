package com.onlineexam.portal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Result {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private int userId;
	
	@NotNull
	private int testId;
	
	@NotNull
	private int questionId;
	
//	@NotNull
	private Date examDate;
	
	@NotNull
	private int examScore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getExamScore() {
		return examScore;
	}

	public void setExamScore(int examScore) {
		this.examScore = examScore;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", userId=" + userId + ", testId=" + testId + ", questionId=" + questionId
				+ ", examDate=" + examDate + ", examScore=" + examScore + "]";
	}
	
}
