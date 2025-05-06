package com.schedule.schedulewalkproject.domain.schedule.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleCreatRequestDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleCreatResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleListResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleUpdateRequestDto;
import com.schedule.schedulewalkproject.domain.schedule.service.ScheduleService;

@RestController   // @Controller + @ResponseBody
@RequestMapping("/schedules")
@RequiredArgsConstructor // final 필드를 매개변수로 가진 생성자를 만든다.
public class ScheduleController {

	private final ScheduleService scheduleService;

	// 1. 일정 생성
	@PostMapping
	public ResponseEntity<ScheduleCreatResponseDto> save(@RequestBody ScheduleCreatRequestDto scheduleRequestDto) {

		ScheduleCreatResponseDto responseDto = scheduleService.save(scheduleRequestDto);

		return ResponseEntity.ok().body(responseDto);
	}

	// 2. 일정 전체 조회
	@GetMapping // 전체 조회
	public ResponseEntity<ScheduleListResponseDto> findAll(){

		ScheduleListResponseDto scheduleListResponseDto = scheduleService.findAll();

		return ResponseEntity.ok().body(scheduleListResponseDto);
	}
	// 3. 단건 일정 조회
	@GetMapping("/{id}")
	public ResponseEntity<ScheduleResponseDto> findbyId(@PathVariable Long id){

		ScheduleResponseDto scheduleResponseDto = scheduleService.findbyId(id);

		return ResponseEntity.ok().body(scheduleResponseDto);
	}

	// 4. 일정 수정
	@PatchMapping("/{id}")
	public ResponseEntity<ScheduleResponseDto> updateSchedule(
		@PathVariable Long id,
		@RequestBody ScheduleUpdateRequestDto scheduleUpdateRequestDto) {

		ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id ,scheduleUpdateRequestDto);

		return ResponseEntity.ok().body(scheduleResponseDto);
	}
	// 5. 일정 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		scheduleService.delete(id);

		return ResponseEntity.ok().body(null);
	}
}
