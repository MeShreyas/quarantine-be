package com.covid.self;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SelfAssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfAssesmentApplication.class, args);
	}

}
