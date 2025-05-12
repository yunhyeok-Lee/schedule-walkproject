package com.schedule.schedulewalkproject.domain.recomment.dto;

import java.time.LocalDateTime;

public class ReCommentResponseDto {

	private final Long id;
	private final String content;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

	public ReCommentResponseDto(Long id, String content,LocalDateTime createdAt ,LocalDateTime updatedAt) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
