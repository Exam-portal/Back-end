package com.onlineexam.portal.dao;

import java.util.List;

import com.onlineexam.portal.model.TestManagement;

public interface TestManagementDAO {

	public void addTest(TestManagement test);

	public TestManagement findTest(int id);

	public List<TestManagement> findAllTest();

	public boolean updateTest(TestManagement test);

	public boolean deleteTest(int id);

}
