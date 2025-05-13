package com.schedule.schedulewalkproject.domain.comment.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentResponseDto;

@Getter
public class CommentResponseDto {

	private final Long id;
	private final String content;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;
	private final List<ReCommentResponseDto> recomments;

	public CommentResponseDto(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt, List<ReCommentResponseDto> recomments) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.recomments = recomments;
	}
}
