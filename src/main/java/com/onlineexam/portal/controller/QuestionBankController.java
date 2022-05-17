package com.onlineexam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.portal.dao.QuestionBankService;
import com.onlineexam.portal.model.QuestionBank;

@RestController
public class QuestionBankController {

	@Autowired
	QuestionBankService questionBankService;

	@GetMapping("/findAllQuestionBank/{testId}")
	public ResponseEntity<?> findAllQuestionBank(@PathVariable(value = "testId") int testId) throws FindAllQuestionBankExcpetion {
		if (testId <= 0) {
			throw new FindAllQuestionBankExcpetion();
		}
		return ResponseEntity.ok(questionBankService.findAllQuestionBank(testId));
	}

	@PostMapping("/addQuestionBank")
	public ResponseEntity<?> addQuestionBank(@RequestBody QuestionBank questionBank) throws AddQuestionBankException {
		if (questionBank == null) {
			throw new AddQuestionBankException();
		}
		questionBankService.addQuestionBank(questionBank);
		return ResponseEntity.ok("user history added successfully");
	}

	@PostMapping("/updateQuestionBank")
	public ResponseEntity<?> updateQuestionBank(@RequestBody QuestionBank questionBank) throws UpdateQuestionBankException {
		if (questionBank == null) {
			throw new UpdateQuestionBankException();
		}
		boolean status = questionBankService.update(questionBank);
		if (!status)
			throw new UpdateQuestionBankException();
		return ResponseEntity.ok("user history updated successfully");
	}

	@PostMapping("/deleteQuestionBank")
	public ResponseEntity<?> deleteQuestionBank(@RequestBody QuestionBank questionBank) throws DeleteQuestionBankException {
		if (questionBank == null) {
			throw new DeleteQuestionBankException();
		}
		boolean status = questionBankService.delete(questionBank);
		if (!status)
			throw new DeleteQuestionBankException();
		return ResponseEntity.ok("user history deleted successfully");
	}

	@GetMapping("/getQuestionBankById/{id}")
	public ResponseEntity<?> getQuestionBankById(@PathVariable(value = "id") int id) throws GetQuestionBankIdException {
		if (id <= 0) {
			throw new GetQuestionBankIdException();
		}
		return ResponseEntity.ok(questionBankService.findResult(id));
	}
	
}
