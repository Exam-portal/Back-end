package com.onlineexam.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.model.TestManagement;

@Component
public class TestManagementDAOImpl implements TestManagementDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void addTest(TestManagement test) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(test);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public TestManagement findTest(int id) {

		Session session = sessionFactory.openSession();
		TestManagement test = session.find(TestManagement.class, id);
		session.close();
		return test;
	}

	public List<TestManagement> findAllTest() {
		Session session = sessionFactory.openSession();
		List<TestManagement> testlist = session.createQuery("select t from TestManagement t").list();
		session.close();
		return testlist;

	}

	public boolean updateTest(TestManagement test) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(test);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;

	}

	public boolean deleteTest(int id) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		TestManagement test = session.find(TestManagement.class, id);
		session.delete(test);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;

	}

}
