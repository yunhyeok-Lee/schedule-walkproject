package com.schedule.schedulewalkproject.domain.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

	private final String title;

	private final String content;

	public ScheduleRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
