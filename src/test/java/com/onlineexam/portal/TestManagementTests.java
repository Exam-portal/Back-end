package com.onlineexam.portal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.onlineexam.portal.controller.AddTestException;
import com.onlineexam.portal.controller.DeleteTestException;
import com.onlineexam.portal.controller.GetTestException;
import com.onlineexam.portal.controller.TestManagementController;
import com.onlineexam.portal.controller.UpdateTestException;
import com.onlineexam.portal.dao.TestManagementService;
import com.onlineexam.portal.model.TestManagement;

@SpringBootTest
class TestManagementTests {

	@Autowired
	TestManagementController controller;
	
	@Autowired
	TestManagementService service;
	
	@Test
	void getTestManagement() {
		TestManagement test = new TestManagement();
		test.setCourseTest("test 1");
		service.add(test);
		assertNotNull(controller.getTestManagement());
	}
	
	@Test
	void testAddSuccess() {
		TestManagement test = new TestManagement();
		test.setCourseTest("test 2");
		assertEquals(ResponseEntity.ok("Test added successfully"), controller.addTest(test));
	}

	@Test
	void testAddFailure() {
		try {
			controller.addTest(null);
	        assert false;
	    } catch (AddTestException e) {
	    	assertEquals(e.toString(), "Test is not added, some data is missing");
	        assert true;
	    }
	}
	
	@Test
	void updateTestSuccess() {
		TestManagement test = new TestManagement();
		test.setCourseTest("test 2");
		service.add(test);
		List<TestManagement> results=service.findAllTest();
		assertEquals(ResponseEntity.ok("Test updated successfully"), controller.updateTestManagement(results.get(results.size()-1)));
	}
	
	@Test
	void updateTestFailure() {
		try {
			controller.updateTestManagement(null);
	        assert false;
	    } catch (UpdateTestException e) {
	    	assertEquals(e.toString(), "Test is not updated, some data is missing");
	        assert true;
	    }
	}
	
	@Test
	void deleteTestSuccess() {
		TestManagement test = new TestManagement();
		test.setCourseTest("test 3");
		service.add(test);
		List<TestManagement> results=service.findAllTest();
		assertEquals(ResponseEntity.ok("Test deleted successfully"), controller.deleteTest(results.get(results.size()-1)));
	}
	
	@Test
	void deleteTestFailure() {
		try {
			controller.deleteTest(null);
	        assert false;
	    } catch (DeleteTestException e) {
	    	assertEquals(e.toString(), "Test is not deleted, some data is missing");
	        assert true;
	    }
	}
	
	@Test
	void getTestByIdSuccess() {
		TestManagement test = new TestManagement();
		test.setCourseTest("test 4");
		service.add(test);
		List<TestManagement> results=service.findAllTest();
		assertNotNull(controller.getTestById(results.get(results.size()-1).getTestId()));
	}
	
	@Test
	void getTestByIdFailure() {
		try {
			controller.getTestById(0);
	        assert false;
	    } catch (GetTestException e) {
	    	assertEquals(e.toString(), "Test is not found");
	        assert true;
	    }
	}
}
