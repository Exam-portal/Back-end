package com.onlineexam.portal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.model.Question;

@Component
public class QuestionDaoImpl implements QuestionDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Question> findAllQuestion(int questionBankId) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("select u from Question u where u.questionBankId = :questionBankId");
	    query.setInteger("questionBankId", questionBankId);
	    List<Question> questionList = query.getResultList();
	    session.close();
		return questionList;
	}

	@Override
	public void addQuestion(Question question) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(question);
		session.flush();
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public Question findQuestion(int id) {
		Session session=sessionFactory.openSession();
		Question question = session.find(Question.class, id);
		session.close();
		return question;
	}

	@Override
	public boolean updateQuestion(Question question) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(question);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteQuestion(Question question) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Question questionInfo= (Question)session.load(Question.class,question.getId());
	    session.delete(questionInfo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public void addBulkQuestions(List<Question> questionList) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(questionList);
		session.flush();
		session.getTransaction().commit();
		session.close();	
	}
	
	
}
