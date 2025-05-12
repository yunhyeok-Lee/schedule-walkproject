package com.schedule.schedulewalkproject.domain.schedule.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.cglib.core.Local;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentResponseDto;

@Getter
@AllArgsConstructor
public class ScheduleDetailResponseDto {

	private final Long id;
	private final String title;
	private final String content;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;
	private final List<CommentResponseDto> commentResponseDtos;
}
