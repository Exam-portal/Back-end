package com.onlineexam.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int questionBankId;
	
	private String questionDes;
	
	private String optionA;
	
	private String optionB;
	
	private String optionC;
	
	private String optionD;

	private String rightAnswer;
	
	
	public String getQuestionDes() {
		return questionDes;
	}

	public void setQuestionDes(String questionDes) {
		this.questionDes = questionDes;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionBankId=" + questionBankId + ", questionDes=" + questionDes
				+ ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(int questionBankId) {
		this.questionBankId = questionBankId;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	
}
