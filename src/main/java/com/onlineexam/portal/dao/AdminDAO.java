package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineexam.portal.model.Admin;
@Repository
public interface AdminDAO {
	
public void addAdmin(Admin admin);
	
	public Admin findAdmin(int id);
	
	public List<Admin> findAllAdmin();
	
	public boolean updateAdmin(Admin admin);
	    
	public boolean deleteAdmin(int id);
	
	public boolean createAdmin( int id);
	
	public String login(Admin admin);
	
    public void changePassword(Admin admin);

	void saveOrUpdateAdmin(Admin admin);
	
	public Admin getByEmail (String email);

}
