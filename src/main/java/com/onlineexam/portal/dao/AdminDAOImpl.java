package com.onlineexam.portal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.model.Admin;

@Component
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addAdmin(Admin admin) {

		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Admin findAdmin(int id) {

		Session session = sessionFactory.openSession();
		Admin admin = session.find(Admin.class, id);
		session.close();
		return admin;
	}

	@Override
	public List<Admin> findAllAdmin() {
		Session session = sessionFactory.openSession();
		List<Admin> adminlist = session.createQuery("select a from Admin a").list();
		session.close();
		return adminlist;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteAdmin(int id) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Admin admin = session.find(Admin.class, id);
		session.delete(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean createAdmin(int id) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Admin admin = session.find(Admin.class, id);
		session.update(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public String login(Admin admin) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select a from Admin a where a.id = :adminId and a.password = :password");
		Admin adminDetails = session.find(Admin.class, admin.getId());
		session.close();
		if (adminDetails.getPassword().equals(admin.getPassword())) {
			return "Success";
		}
		return "Fail";
	}

	@Override
	public void changePassword(Admin admin) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Admin adminDetails = session.find(Admin.class, admin.getId());
		adminDetails.setPassword(admin.getPassword());
		session.update(adminDetails);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void saveOrUpdateAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Admin getByEmail(String email) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select a from Admin a where a.email=:email");
		query.setParameter("email", email);

		List<Admin> list = query.list();
		session.close();
		return list.get(0);
	}

}
