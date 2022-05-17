package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.QuestionBank;

@Service
public class QuestionBankService {

	@Autowired
	QuestionBankDaoImpl questionBankDaoImpl;
	
	public List<QuestionBank> findAllQuestionBank(int questionBankBankId){
		return questionBankDaoImpl.findAllQuestionBank(questionBankBankId);
	}
	
	public void addQuestionBank(QuestionBank questionBank) {
		questionBankDaoImpl.addQuestionBank(questionBank);
	}

	public boolean update(QuestionBank questionBank) {
		return questionBankDaoImpl.updateQuestionBank(questionBank);
	}

	public boolean delete(QuestionBank questionBank) {
		return questionBankDaoImpl.deleteQuestionBank(questionBank);
	}

	public Object findResult(int id) {
		return questionBankDaoImpl.findQuestionBank(id);
	}
}
