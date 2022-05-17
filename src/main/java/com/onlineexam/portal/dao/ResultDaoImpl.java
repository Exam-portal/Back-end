package com.onlineexam.portal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.model.Result;

@Component
public class ResultDaoImpl implements ResultDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Result> findAllResult(int userId) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("select r from Result r where r.userId = :userId");
	    query.setInteger("userId", userId);
	    List<Result> resultList = query.getResultList();
	    session.close();
		return resultList;
	}

	@Override
	public void addResult(Result result) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(result);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Result findResult(int id) {
		Session session=sessionFactory.openSession();
		Result result = session.find(Result.class, id);
		session.close();
		return result;
	}

	@Override
	public boolean updateResult(Result result) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(result);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteResult(Result result) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Result resultInfo= (Result)session.load(Result.class,result.getId());
	    session.delete(resultInfo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	
}
