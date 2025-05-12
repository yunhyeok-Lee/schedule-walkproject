package com.schedule.schedulewalkproject.domain.schedule.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleListResponseDto {

	// private List<ScheduleResponseDto> scheduleResponseDtos;
	private List<ScheduleCountResponseDto> scheduleCountResponseDtos;
}


