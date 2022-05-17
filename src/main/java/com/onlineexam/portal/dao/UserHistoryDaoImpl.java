package com.onlineexam.portal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.model.UserHistory;

@Component
public class UserHistoryDaoImpl implements UserHistoryDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<UserHistory> findAllUserHistory(int userId) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("select u from UserHistory u where u.userId = :userId");
	    query.setInteger("userId", userId);
	    List<UserHistory> historyList = query.getResultList();
	    session.close();
		return historyList;
	}

	@Override
	public void addUserHistory(UserHistory userHistory) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(userHistory);
		session.flush();
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public UserHistory findUser(int id) {
		Session session=sessionFactory.openSession();
		UserHistory userHistory = session.find(UserHistory.class, id);
		session.close();
		return userHistory;
	}

	@Override
	public boolean updateUser(UserHistory userHistory) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(userHistory);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteUser(UserHistory userHistory) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		UserHistory userHistoryInfo= (UserHistory)session.load(UserHistory.class,userHistory.getId());
	    session.delete(userHistoryInfo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
}
