package com.schedule.schedulewalkproject.domain.recomment.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ReCommentCreatResponseDto {

	private final Long id;
	private final String content;
	private final LocalDateTime createdAt;

	public ReCommentCreatResponseDto(Long id, String content, LocalDateTime createdAt) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
	}
}
