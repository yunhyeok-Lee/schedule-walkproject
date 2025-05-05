package com.schedule.schedulewalkproject.domain.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleCreatRequestDto {

	private final String title;

	private final String content;

	public ScheduleCreatRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
