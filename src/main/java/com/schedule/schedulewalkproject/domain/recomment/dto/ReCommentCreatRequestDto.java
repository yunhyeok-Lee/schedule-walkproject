package com.schedule.schedulewalkproject.domain.recomment.dto;

import lombok.Getter;

@Getter
public class ReCommentCreatRequestDto {

	private final String content;

	public ReCommentCreatRequestDto(String content) {
		this.content = content;
	}
}
