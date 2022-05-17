package com.onlineexam.portal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.onlineexam.portal.controller.AddResultException;
import com.onlineexam.portal.controller.DeleteResultException;
import com.onlineexam.portal.controller.GetResultException;
import com.onlineexam.portal.controller.GetResultsException;
import com.onlineexam.portal.controller.ResultController;
import com.onlineexam.portal.controller.UpdateResultException;
import com.onlineexam.portal.dao.ResultService;
import com.onlineexam.portal.model.Result;

@SpringBootTest
public class ResultTests {

	@Autowired
	ResultService resultService;
	
	@Autowired
	ResultController resultController;
	
	@Test
	void testGetAllResultSuccess() {
		Result result = new Result();
		result.setUserId(1);
		result.setTestId(1);
		result.setQuestionId(2);
		result.setExamDate(new Date());
		result.setExamScore(25);
//		assertEquals(ResponseEntity.ok(resultService.getAllResult(1)),resultController.getAllResults(1));
		assertNotNull(resultController.getAllResults(1));
	}
	
	@Test
	void testGetAllResultFailure() {
		try {
			resultController.getAllResults(0);
	        assert false;
	    } catch (GetResultsException e) {
	    	assertEquals(e.toString(), "Unable to fetch results with userId: 0");
	        assert true;
	    }
	}
	
	@Test
	void testAddResultSuccess() {
		Result result = new Result();
		result.setUserId(1);
		result.setTestId(1);
		result.setQuestionId(2);
		result.setExamDate(new Date());
		result.setExamScore(25);
		assertEquals(ResponseEntity.ok("result added successfully"), resultController.addResult(result));
	}
	
	@Test
	void testAddResultFailure() {
		try {
			resultController.addResult(null);
	        assert false;
	    } catch (AddResultException e) {
	    	assertEquals(e.toString(), "Result is not added, some data is missing");
	        assert true;
	    }
	}
	
	@Test
	void updateResultSuccess() {
		Result result = new Result();
		result.setUserId(1);
		result.setTestId(1);
		result.setQuestionId(2);
		result.setExamDate(new Date());
		result.setExamScore(25);
		resultService.add(result);
		List<Result> results=resultService.getAllResult(1);
		assertEquals(ResponseEntity.ok("result updated successfully"), resultController.updateResult(results.get(results.size()-1)));
	}
	
	@Test
	void updateResultFailure() {
		try {
			resultController.updateResult(null);
	        assert false;
	    } catch (UpdateResultException e) {
	    	assertEquals(e.toString(), "Unable to update result");
	        assert true;
	    }
	}
	
	@Test
	void deleteResult() {
		Result result = new Result();
		result.setUserId(1);
		result.setTestId(1);
		result.setQuestionId(2);
		result.setExamDate(new Date());
		result.setExamScore(25);
		resultService.add(result);
		List<Result> results=resultService.getAllResult(1);
		assertEquals(ResponseEntity.ok("result deleted successfully"), resultController.deleteResult(results.get(results.size()-1)));
	}
	
	@Test
	void deleteResultFailure() {
		try {
			resultController.deleteResult(null);
	        assert false;
	    } catch (DeleteResultException e) {
	    	assertEquals(e.toString(), "Unable to delete result");
	        assert true;
	    }
	}
	
	@Test
	void findResult() {
		Result result = new Result();
		result.setUserId(1);
		result.setTestId(1);
		result.setQuestionId(2);
		result.setExamDate(new Date());
		result.setExamScore(25);
		resultService.add(result);
		List<Result> results=resultService.getAllResult(1);
		assertNotNull(resultController.getAllResultById(results.get(results.size()-1).getId()));
	}
	
	@Test
	void findResultFailure() {
		try {
			resultController.getAllResultById(0);
	        assert false;
	    } catch (GetResultException e) {
	    	assertEquals(e.toString(), "Unable to fetch result with id: 0");
	        assert true;
	    }
	}
}
