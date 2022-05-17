package com.onlineexam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.portal.dao.ResultService;
import com.onlineexam.portal.model.Result;

@RestController
public class ResultController {

	@Autowired
	ResultService resultService;
	
	@GetMapping("/getResults/{userId}")
	public ResponseEntity<?> getAllResults(@PathVariable(value="userId") int userId) throws GetResultsException{
		if(userId<=0) {
			throw new GetResultsException(userId); 
		}
		return ResponseEntity.ok(resultService.getAllResult(userId));
	}
	
	@PostMapping("/addResult")
	public ResponseEntity<?> addResult(@RequestBody Result result) throws AddResultException{
		if(result==null) {
			throw new AddResultException();
		}
		resultService.add(result);
		return ResponseEntity.ok("result added successfully");
	}
	
	@PostMapping("/updateResult")
	public ResponseEntity<?> updateResult(@RequestBody Result result) throws UpdateResultException{
		if(result==null) {
			throw new UpdateResultException();
		}
		boolean status=resultService.update(result);
		if(!status) throw new UpdateResultException();
		return ResponseEntity.ok("result updated successfully");
	}
	
	@PostMapping("/deleteResult")
	public ResponseEntity<?> deleteResult(@RequestBody Result result) throws DeleteResultException{
		if(result==null) {
			throw new DeleteResultException();
		}
		boolean status=resultService.delete(result);
		if(!status) throw new DeleteResultException();
		return ResponseEntity.ok("result deleted successfully");
	}
	
	@GetMapping("/getAllResultById/{id}")
	public ResponseEntity<?> getAllResultById(@PathVariable(value="id") int id) throws GetResultException{
		if(id<=0) {
			throw new GetResultException(id);
		}
		return ResponseEntity.ok(resultService.findResult(id));
	}
}
