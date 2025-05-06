package com.schedule.schedulewalkproject.domain.comment.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatRequestDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatResponseDto;
import com.schedule.schedulewalkproject.domain.comment.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/schedules/{scheduleId}/comments")
	public ResponseEntity<CommentCreatResponseDto> save(
		@PathVariable Long scheduleId,
		@RequestBody CommentCreatRequestDto commentCreatRequestDto) {

		CommentCreatResponseDto responseDto = commentService.save(scheduleId,commentCreatRequestDto);

		return ResponseEntity.ok().body(responseDto);
	}
}
