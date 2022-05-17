package com.onlineexam.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.portal.dao.QuestionService;
import com.onlineexam.portal.model.Question;

@RestController
public class QuestionContoller {

	@Autowired
	QuestionService questionService;
    
	@GetMapping("/findAllQuestion/{questionBankId}")
	public ResponseEntity<?> findAllQuestion(@PathVariable(value = "questionBankId") int questionBankId) throws FindAllQuestionExcpetion {
		if (questionBankId <= 0) {
			throw new FindAllQuestionExcpetion();
		}
		return ResponseEntity.ok(questionService.findAllQuestion(questionBankId));
	}
	
    @CrossOrigin("*")
	@PostMapping("/addQuestion")
	public ResponseEntity<?> addQuestion(@RequestBody Question question) throws AddQuestionException {
		if (question == null) {
			throw new AddQuestionException();
		}
		questionService.addQuestion(question);
		return ResponseEntity.ok("question added successfully");
	}

     @CrossOrigin("*")
     @GetMapping("/findQuestion/{id}")
     public  Question findQuestion(@PathVariable int id){
    	 
     return questionService.findQuestion(id);

     }
     
	@PostMapping("/updateQuestion")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question) throws UpdateQuestionException {
		if (question == null) {
			throw new UpdateQuestionException();
		}
		boolean status = questionService.update(question);
		if (!status)
			throw new UpdateQuestionException();
		return ResponseEntity.ok("question updated successfully");
	}

	@PostMapping("/deleteQuestion")
	public ResponseEntity<?> deleteQuestion(@RequestBody Question question) throws DeleteQuestionException {
		if (question == null) {
			throw new DeleteQuestionException();
		}
		boolean status = questionService.delete(question);
		if (!status)
			throw new DeleteQuestionException();
		return ResponseEntity.ok("question deleted successfully");
	}

	@GetMapping("/getQuestionById/{id}")
	public ResponseEntity<?> getQuestionById(@PathVariable(value = "id") int id) throws GetQuestionIdException {
		if (id <= 0) {
			throw new GetQuestionIdException();
		}
		return ResponseEntity.ok(questionService.findResult(id));
	}
	
	@PostMapping("/addBulkQuestion")
	public ResponseEntity<?> addBulkQuestion(@RequestBody List<Question> questionList) throws AddQuestionException {
		if (questionList.size()<=0) {
			throw new AddQuestionException();
		}
		questionService.addBulkQuestion(questionList);
		return ResponseEntity.ok("Bulk questions added successfully");
	}
}
