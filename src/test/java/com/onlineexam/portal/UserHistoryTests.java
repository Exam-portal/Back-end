package com.onlineexam.portal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.onlineexam.portal.controller.AddUserHistoryException;
import com.onlineexam.portal.controller.DeleteUserHistoryException;
import com.onlineexam.portal.controller.GetUserHistoryException;
import com.onlineexam.portal.controller.GetUserHistoryIdException;
import com.onlineexam.portal.controller.UpdateUserHistoryException;
import com.onlineexam.portal.controller.UserHistoryController;
import com.onlineexam.portal.dao.UserHistoryService;
import com.onlineexam.portal.model.UserHistory;

@SpringBootTest
public class UserHistoryTests {

	@Autowired
	UserHistoryService userHistoryService;
	
	@Autowired
	UserHistoryController userHistoryController;
	
	
	@Test
	void getAllUserHistorySuccess() {
		UserHistory userHistory = new UserHistory();
		userHistory.setTestId(1);
		userHistory.setTestDate(new Date());
		userHistory.setTestScore(20);
		userHistory.setUserId(1);
		userHistoryService.addUserHistory(userHistory);
		assertNotNull(userHistoryController.getUserHistory(1));
	}
	
	@Test
	void getAllUserHistoryFailure() {
		try {
			userHistoryController.getUserHistory(0);
	        assert false;
	    } catch (GetUserHistoryException e) {
	    	assertEquals(e.toString(), "Unable to fetch results with userId: 0");
	        assert true;
	    }
	}
	
	@Test
	void testAddUserHistorySuccess() {
		UserHistory userHistory = new UserHistory();
		userHistory.setTestId(1);
		userHistory.setTestDate(new Date());
		userHistory.setTestScore(20);
		userHistory.setUserId(1);
		assertEquals(ResponseEntity.ok("user history added successfully"), userHistoryController.addUserHistory(userHistory));
	}
	
	@Test
	void testAddUserHistoryFailure() {
		try {
			userHistoryController.addUserHistory(null);
	        assert false;
	    } catch (AddUserHistoryException e) {
	    	assertEquals(e.toString(), "User History is not added, some data is missing");
	        assert true;
	    }
	}
	
	@Test
	void updateUserHistorySuccess() {
		UserHistory userHistory = new UserHistory();
		userHistory.setTestId(1);
		userHistory.setTestDate(new Date());
		userHistory.setTestScore(20);
		userHistory.setUserId(1);
		userHistoryService.addUserHistory(userHistory);
		List<UserHistory> results=userHistoryService.findAllUserHistory(1);
		assertEquals(ResponseEntity.ok("user history updated successfully"), userHistoryController.updateUserHistory(results.get(results.size()-1)));
	}
	
	@Test
	void updateUserHistoryFailure() {
		try {
			userHistoryController.updateUserHistory(null);
	        assert false;
	    } catch (UpdateUserHistoryException e) {
	    	assertEquals(e.toString(), "Unable to update user history");
	        assert true;
	    }
	}
	
	@Test
	void deleteUserHistorySuccess() {
		UserHistory userHistory = new UserHistory();
		userHistory.setTestId(1);
		userHistory.setTestDate(new Date());
		userHistory.setTestScore(20);
		userHistory.setUserId(1);
		userHistoryService.addUserHistory(userHistory);
		List<UserHistory> results=userHistoryService.findAllUserHistory(1);
		assertEquals(ResponseEntity.ok("user history deleted successfully"), userHistoryController.deleteUserHistory(results.get(results.size()-1)));
	}
	
	@Test
	void deleteUserHistoryFailure() {
		try {
			userHistoryController.deleteUserHistory(null);
	        assert false;
	    } catch (DeleteUserHistoryException e) {
	    	assertEquals(e.toString(), "Unable to delete user history");
	        assert true;
	    }
	}
	
	@Test
	void findUserHistorySuccess() {
		UserHistory userHistory = new UserHistory();
		userHistory.setTestId(1);
		userHistory.setTestDate(new Date());
		userHistory.setTestScore(20);
		userHistory.setUserId(1);
		userHistoryService.addUserHistory(userHistory);
		List<UserHistory> results=userHistoryService.findAllUserHistory(1);
		assertNotNull(userHistoryController.getUserHistoryById(results.get(results.size()-1).getId()));
	}
	
	@Test
	void findUserHistoryFailure() {
		try {
			userHistoryController.getUserHistoryById(0);
	        assert false;
	    } catch (GetUserHistoryIdException e) {
	    	assertEquals(e.toString(), "Unable to fetch user history with id: 0");
	        assert true;
	    }
	}
}
