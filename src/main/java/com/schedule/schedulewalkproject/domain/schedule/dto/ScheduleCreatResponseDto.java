package com.schedule.schedulewalkproject.domain.schedule.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ScheduleCreatResponseDto {

	private final Long id;
	private final String title;
	private final String content;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

	public ScheduleCreatResponseDto(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
