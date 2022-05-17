package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.Result;

@Service
public class ResultService {

	@Autowired
	ResultDaoImpl resultDaoImpl;
	
	public List<Result> getAllResult(int userId) {
		return resultDaoImpl.findAllResult(userId);
	}

	public void add(Result result) {
		resultDaoImpl.addResult(result);
	}

	public boolean update(Result result) {
		return resultDaoImpl.updateResult(result);
	}

	public boolean delete(Result result) {
		return resultDaoImpl.deleteResult(result);
	}

	public Result findResult(int id) {
		return resultDaoImpl.findResult(id);
	}
}
