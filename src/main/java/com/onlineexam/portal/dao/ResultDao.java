package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineexam.portal.model.Result;

@Repository
public interface ResultDao {

	public void addResult(Result Result);
	public Result findResult(int id);
	public List<Result> findAllResult(int userId);
	public boolean updateResult(Result Result);
	public boolean deleteResult(Result Result);
}
