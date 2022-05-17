package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.UserHistory;

@Service
public class UserHistoryService {

	@Autowired
	UserHistoryDaoImpl userHistoryDaoImpl;
	
	public List<UserHistory> findAllUserHistory(int userId){
		return userHistoryDaoImpl.findAllUserHistory(userId);
	}
	
	public void addUserHistory(UserHistory userHistory) {
		userHistoryDaoImpl.addUserHistory(userHistory);
	}

	public boolean update(UserHistory userHistory) {
		return userHistoryDaoImpl.updateUser(userHistory);
	}

	public boolean delete(UserHistory userHistory) {
		return userHistoryDaoImpl.deleteUser(userHistory);
	}

	public Object findResult(int id) {
		return userHistoryDaoImpl.findUser(id);
	}
	

}
