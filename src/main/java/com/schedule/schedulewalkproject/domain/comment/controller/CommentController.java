package com.schedule.schedulewalkproject.domain.comment.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatRequestDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentListResponseDto;
import com.schedule.schedulewalkproject.domain.comment.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	/*
	 * 1. 댓글 작성
	 */
	@PostMapping("/schedules/{scheduleId}/comments")
	public ResponseEntity<CommentCreatResponseDto> save(
		@PathVariable Long scheduleId,
		@RequestBody CommentCreatRequestDto commentCreatRequestDto) {

		CommentCreatResponseDto responseDto = commentService.save(scheduleId,commentCreatRequestDto);

		return ResponseEntity.ok().body(responseDto);
	}
	/*
	 * 2. 댓글 조회
	 */
	@GetMapping("/schedules/{scheduleId}/comments")
	public ResponseEntity<CommentListResponseDto> findAll(){

		CommentListResponseDto commentListResponseDto = commentService.findAll();

		return ResponseEntity.ok().body(commentListResponseDto);
	}


}
