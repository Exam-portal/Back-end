package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineexam.portal.model.Question;

@Repository
public interface QuestionDao {
	public List<Question> findAllQuestion(int questionBankId);
	public void addQuestion(Question question);
	public Question findQuestion(int id);
	public boolean updateQuestion(Question question);
	public boolean deleteQuestion(Question question);
	public void addBulkQuestions(List<Question> questionList);
}
