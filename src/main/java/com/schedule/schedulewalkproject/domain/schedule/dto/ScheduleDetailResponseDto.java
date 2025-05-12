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

	private Long id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<CommentResponseDto> commentResponseDtos;
}
