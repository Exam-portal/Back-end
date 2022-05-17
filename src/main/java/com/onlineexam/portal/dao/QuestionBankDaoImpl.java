package com.onlineexam.portal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.model.QuestionBank;

@Component
public class QuestionBankDaoImpl implements QuestionBankDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<QuestionBank> findAllQuestionBank(int testId) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("select u from QuestionBank u where u.testId = :testId");
	    query.setInteger("testId", testId);
	    List<QuestionBank> questionBankList = query.getResultList();
	    session.close();
		return questionBankList;
	}

	@Override
	public void addQuestionBank(QuestionBank questionBank) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(questionBank);
		session.flush();
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public QuestionBank findQuestionBank(int id) {
		Session session=sessionFactory.openSession();
		QuestionBank questionBank = session.find(QuestionBank.class, id);
		session.close();
		return questionBank;
	}

	@Override
	public boolean updateQuestionBank(QuestionBank questionBank) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(questionBank);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteQuestionBank(QuestionBank questionBank) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		QuestionBank questionBankInfo= (QuestionBank)session.load(QuestionBank.class,questionBank.getQuestionBankId());
	    session.delete(questionBankInfo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
}
