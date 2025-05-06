package com.schedule.schedulewalkproject.domain.comment.dto;

import lombok.Getter;

@Getter
public class CommentCreatRequestDto {

	private final String content;

	public CommentCreatRequestDto(String content) {
		this.content = content;
	}
}
