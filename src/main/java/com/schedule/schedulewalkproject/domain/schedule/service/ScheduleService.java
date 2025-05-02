package com.schedule.schedulewalkproject.domain.schedule.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleRequestDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;
import com.schedule.schedulewalkproject.domain.schedule.repository.ScheduleRepository;

@Service // Spring Bean으로 등록
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;

	public ScheduleResponseDto save(ScheduleRequestDto scheduleRequestDto) {

		Schedule schedule = new Schedule(scheduleRequestDto.getTitle(), scheduleRequestDto.getContent());

		Schedule savedSchedule = scheduleRepository.save(schedule);

		return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContent(),savedSchedule.getCreatedAt(),savedSchedule.getUpdatedAt());

	}
}
