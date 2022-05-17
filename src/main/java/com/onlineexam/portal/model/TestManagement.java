package com.onlineexam.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TestManagement {
	
	@Id
	@GeneratedValue
	private int testId;
	
	
	@NotNull(message="Course Type cannot be null")
	@Column(name="courseName")
	private String courseTest;


	@Override
	public String toString() {
		return "TestManagement [testId=" + testId + ", courseTest=" + courseTest + "]";
	}


	public int getTestId() {
		return testId;
	}


	public void setTestId(int testId) {
		this.testId = testId;
	}


	public String getCourseTest() {
		return courseTest;
	}


	public void setCourseTest(String courseTest) {
		this.courseTest = courseTest;
	}
	
	
}
