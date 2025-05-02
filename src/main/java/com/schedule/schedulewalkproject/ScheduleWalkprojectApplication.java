package com.schedule.schedulewalkproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleWalkprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleWalkprojectApplication.class, args);
	}

}
