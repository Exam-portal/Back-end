package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineexam.portal.model.QuestionBank;

@Repository
public interface QuestionBankDao {
	public List<QuestionBank> findAllQuestionBank(int testId);
	public void addQuestionBank(QuestionBank questionBank);
	public QuestionBank findQuestionBank(int id);
	public boolean updateQuestionBank(QuestionBank questionBank);
	public boolean deleteQuestionBank(QuestionBank questionBank);
}
