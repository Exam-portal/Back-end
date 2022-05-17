package com.onlineexam.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan({"com.onlineexam.portal.model"})
public class OnlineExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExamApplication.class, args);
	}

}
