package com.schedule.schedulewalkproject.domain.comment.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class CommentResponseDto {

	private final Long id;
	private final String content;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

	public CommentResponseDto(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
