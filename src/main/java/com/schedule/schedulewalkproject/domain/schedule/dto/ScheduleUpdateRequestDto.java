package com.schedule.schedulewalkproject.domain.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {
	private final String title;
	private final String content;

	public ScheduleUpdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
