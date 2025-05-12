package com.schedule.schedulewalkproject.domain.recomment.dto;

import lombok.Getter;

@Getter
public class ReCommentUpdateRequestDto {

	private final String content;

	public ReCommentUpdateRequestDto(String content) {
		this.content = content;
	}
}
