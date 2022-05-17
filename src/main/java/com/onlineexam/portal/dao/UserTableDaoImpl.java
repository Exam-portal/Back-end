package com.onlineexam.portal.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.model.UserTable;

@Component
public class UserTableDaoImpl implements UserTableDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String login(UserTable user) {
		Session session = sessionFactory.openSession();
		UserTable userDetails = session.find(UserTable.class, user.getId());
		session.close();
		if (userDetails.getPassword().equals(user.getPassword())) {
			return "Success";
		}
		return "Fail";
	}

	@Override
	public void add(UserTable user) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(user);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void changePassword(UserTable user) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		UserTable userDetails = session.find(UserTable.class, user.getId());
		userDetails.setPassword(user.getPassword());
		session.update(userDetails);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public String viewPassword(UserTable user) {
		Session session = sessionFactory.openSession();
		UserTable userDetails = session.find(UserTable.class, user.getId());
		session.close();
		if (userDetails != null) {
			return userDetails.getPassword();
		}
		return "No User Found";
	}

	public UserTable findUser(int id) {

		Session session = sessionFactory.openSession();
		UserTable userDetails = session.find(UserTable.class, id);
		session.close();
		return userDetails;
	}

	@Override
	public void updateCode(UserTable user) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		UserTable userDetails = session.find(UserTable.class, user.getId());
		userDetails.setCode(user.getCode());
		userDetails.setStatus("P");
		session.update(userDetails);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public String verifyCode(UserTable user) {
		Session session = sessionFactory.openSession();
		UserTable userDetails = session.find(UserTable.class, user.getId());
		session.close();
		if (userDetails.getCode().equals(user.getCode())) {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			userDetails.setStatus("A");
			session.update(userDetails);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return "User Activated Successfully";
		}
		return "User Activation failed";
	}

	@Override
	public List<UserTable> findAllUser() {

		return null;
	}

	@Override
	public List<UserTable> getByEmail(String email) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select u from UserTable u where u.email=:email");
		query.setParameter("email", email);

		List<UserTable> list = query.getResultList();
		session.close();
		return list;
	}

	@Override
	public void saveOrUpdateUser(UserTable user) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(user);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
