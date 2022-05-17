package com.onlineexam.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestionBank {

	@Id
	@GeneratedValue
	private int questionBankId;
	
	private int testId;
	
	private int questionId;

	@Override
	public String toString() {
		return "QuestionBankDao [questionBankId=" + questionBankId + ", testId=" + testId + ", questionId=" + questionId
				+ "]";
	}

	public int getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(int questionBankId) {
		this.questionBankId = questionBankId;
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
	
	
}
