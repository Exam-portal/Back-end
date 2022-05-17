package com.onlineexam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.portal.dao.UserHistoryService;
import com.onlineexam.portal.model.UserHistory;

@RestController
public class UserHistoryController {

	@Autowired
	UserHistoryService userHistoryService;
	
	@GetMapping("/getUserHistory/{userId}")
	public ResponseEntity<?> getUserHistory(@PathVariable(value="userId") int userId) throws GetUserHistoryException {
		if(userId<=0) {
			throw new GetUserHistoryException(userId); 
		}
		return ResponseEntity.ok(userHistoryService.findAllUserHistory(userId));
	}
	
	@PostMapping("/addUserHistory")
	public ResponseEntity<?> addUserHistory(@RequestBody UserHistory userHistory) throws AddUserHistoryException{
		if(userHistory==null) {
			throw new AddUserHistoryException();
		}
		userHistoryService.addUserHistory(userHistory);
		return ResponseEntity.ok("user history added successfully");
	}
	
	@PostMapping("/updateUserHistory")
	public ResponseEntity<?> updateUserHistory(@RequestBody UserHistory userHistory) throws UpdateUserHistoryException{
		if(userHistory==null) {
			throw new UpdateUserHistoryException();
		}
		boolean status=userHistoryService.update(userHistory);
		if(!status) throw new UpdateUserHistoryException();
		return ResponseEntity.ok("user history updated successfully");
	}
	
	@PostMapping("/deleteUserHistory")
	public ResponseEntity<?> deleteUserHistory(@RequestBody UserHistory userHistory) throws DeleteUserHistoryException{
		if(userHistory==null) {
			throw new DeleteUserHistoryException();
		}
		boolean status=userHistoryService.delete(userHistory);
		if(!status) throw new DeleteUserHistoryException();
		return ResponseEntity.ok("user history deleted successfully");
	}
	
	@GetMapping("/getUserHistoryById/{id}")
	public ResponseEntity<?> getUserHistoryById(@PathVariable(value="id") int id) throws GetUserHistoryIdException{
		if(id<=0) {
			throw new GetUserHistoryIdException(id);
		}
		return ResponseEntity.ok(userHistoryService.findResult(id));
	}
}
