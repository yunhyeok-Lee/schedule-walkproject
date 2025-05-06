package com.schedule.schedulewalkproject.domain.comment.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentListResponseDto {

	private List<CommentResponseDto> commentResponseDtos;


}
