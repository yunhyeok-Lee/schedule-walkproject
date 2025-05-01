package com.schedule.schedulewalkproject.domain.schedule.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;
import com.schedule.schedulewalkproject.domain.schedule.service.ScheduleService;

@RestController
@RequestMapping(/"schedules")
@RequiredArgsConstructor
public class ScheduleController {

	private final ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<ScheduleResponseDto> save

	return new ResponseEntity<>

}
