package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.TestManagement;

@Service
public class TestManagementService {

	@Autowired
	TestManagementDAO testManagementDAO;

	public void add(TestManagement test) {

		testManagementDAO.addTest(test);
	}

	public TestManagement findTest(int id) {

		return testManagementDAO.findTest(id);
	}

	public List<TestManagement> findAllTest() {

		return testManagementDAO.findAllTest();

	}

	public boolean updateTest(TestManagement test) {

		return testManagementDAO.updateTest(test);
	}

	public boolean deleteTest(int id) {

		return testManagementDAO.deleteTest(id);
	}

}
