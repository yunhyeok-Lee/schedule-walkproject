package com.schedule.schedulewalkproject.domain.comment.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class CommentCreatResponseDto {

	private final Long id;
	private final String content;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

	public CommentCreatResponseDto(Long id,String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
