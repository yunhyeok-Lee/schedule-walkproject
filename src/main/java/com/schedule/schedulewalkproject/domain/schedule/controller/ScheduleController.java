package com.schedule.schedulewalkproject.domain.schedule.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleRequestDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.service.ScheduleService;

@RestController   // @Controller + @ResponseBody
@RequestMapping("/schedules")
@RequiredArgsConstructor // final 필드를 매개변수로 가진 생성자를 만든다.
public class ScheduleController {

	private final ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto scheduleRequestDto) {

		ScheduleResponseDto responseDto = scheduleService.save(scheduleRequestDto);

		return ResponseEntity.ok().body(responseDto);

	}

}
