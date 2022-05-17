package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDaoImpl questionDaoImpl;
	
	public List<Question> findAllQuestion(int questionBankId){
		return questionDaoImpl.findAllQuestion(questionBankId);
	}
	
	public void addQuestion(Question question) {
		questionDaoImpl.addQuestion(question);
	}

	public Question findQuestion(int id) {
		return questionDaoImpl.findQuestion(id);
	}
	public boolean update(Question question) {
		return questionDaoImpl.updateQuestion(question);
	}

	public boolean delete(Question question) {
		return questionDaoImpl.deleteQuestion(question);
	}

	public Object findResult(int id) {	
		return questionDaoImpl.findQuestion(id);
	}

	public void addBulkQuestion(List<Question> questionList) {
		questionDaoImpl.addBulkQuestions(questionList);
	}
}
