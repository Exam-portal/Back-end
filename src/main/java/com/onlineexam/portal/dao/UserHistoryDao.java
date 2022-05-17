package com.onlineexam.portal.dao;

import java.util.List;

import com.onlineexam.portal.model.UserHistory;

public interface UserHistoryDao {

	public List<UserHistory> findAllUserHistory(int userId);
	public void addUserHistory(UserHistory userHistory);
	public UserHistory findUser(int id);
	public boolean updateUser(UserHistory userHistory);
	public boolean deleteUser(UserHistory userHistory);
}
