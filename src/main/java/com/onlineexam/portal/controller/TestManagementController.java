package com.onlineexam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.portal.dao.TestManagementService;
import com.onlineexam.portal.model.TestManagement;

@RestController
public class TestManagementController {

	@Autowired
	TestManagementService testManagementService;
	
	@GetMapping("/getAllTests")
	public ResponseEntity<?> getTestManagement(){
		return ResponseEntity.ok(testManagementService.findAllTest());
	}
	
	@PostMapping("/addTest")
	public ResponseEntity<?> addTest(@RequestBody TestManagement testManagement) throws AddTestException{
		if(testManagement==null) {
			throw new AddTestException();
		}
		testManagementService.add(testManagement);
		return ResponseEntity.ok("Test added successfully");
	}
	
	@PostMapping("/updateTest")
	public ResponseEntity<?> updateTestManagement(@RequestBody TestManagement testManagement) throws UpdateTestException{
		if(testManagement==null) {
			throw new UpdateTestException();
		}
		boolean status=testManagementService.updateTest(testManagement);
		if(!status) throw new UpdateTestException();
		return ResponseEntity.ok("Test updated successfully");
	}
	
	@PostMapping("/deleteTest")
	public ResponseEntity<?> deleteTest(@RequestBody TestManagement testManagement) throws DeleteTestException{
		if(testManagement==null) {
			throw new DeleteTestException();
		}
		boolean status=testManagementService.deleteTest(testManagement.getTestId());
		if(!status) throw new DeleteTestException();
		return ResponseEntity.ok("Test deleted successfully");
	}
	
	@GetMapping("/test/{id}")
	public ResponseEntity<?> getTestById(@PathVariable(value="id") int id) throws GetTestException{
		if(id<=0) {
			throw new GetTestException();
		}
		return ResponseEntity.ok(testManagementService.findTest(id));
	}
}
