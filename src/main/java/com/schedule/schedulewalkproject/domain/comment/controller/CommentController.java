package com.schedule.schedulewalkproject.domain.comment.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatRequestDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentListResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentUpdateRequestDto;
import com.schedule.schedulewalkproject.domain.comment.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;


	// 1. 댓글 작성
	@PostMapping("/schedules/{scheduleId}/comments")
	public ResponseEntity<CommentCreatResponseDto> save(
		@PathVariable Long scheduleId,
		@RequestBody CommentCreatRequestDto commentCreatRequestDto) {

		CommentCreatResponseDto responseDto = commentService.save(scheduleId, commentCreatRequestDto);

		return ResponseEntity.ok().body(responseDto);
	}


	// 2. 댓글 전체 조회
	@GetMapping("/schedules/{scheduleId}/comments")
	public ResponseEntity<CommentListResponseDto> findAll() {

		CommentListResponseDto commentListResponseDto = commentService.findAll();

		return ResponseEntity.ok().body(commentListResponseDto);
	}

	@GetMapping
	public ResponseEntity<CommentResponseDto> findbyId(@PathVariable Long id){

		CommentResponseDto commentResponseDto = commentService.findbyId(id);

		return ResponseEntity.ok().body(commentResponseDto);
	}

	// 3. 댓글 수정
	@PatchMapping("/schedules/{scheduleId}/comments/{id}")
	public ResponseEntity<CommentResponseDto> updateComment(
		@PathVariable Long id,
		@RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {

		CommentResponseDto commentResponseDto = commentService.updateComment(id, commentUpdateRequestDto);

		return ResponseEntity.ok().body(commentResponseDto);
	}
}
