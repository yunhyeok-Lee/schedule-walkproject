package com.schedule.schedulewalkproject.domain.recomment.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentCreatRequestDto;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentCreatResponseDto;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentResponseDto;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentUpdateRequestDto;
import com.schedule.schedulewalkproject.domain.recomment.entity.ReComment;
import com.schedule.schedulewalkproject.domain.recomment.service.ReCommentService;

@Getter
@AllArgsConstructor
@RequestMapping("/schedules/{scheduleId}/{commentId}/recomments")
public class ReCommentController {

	private final ReCommentService reCommentService;

	// 1. 대댓글 작성
	@PostMapping
	public ResponseEntity<ReCommentCreatResponseDto> save(
		@PathVariable Long scheduleId,
		@PathVariable Long commentId,
		@RequestBody ReCommentCreatRequestDto reCommentCreatRequestDto
	){
		ReCommentCreatResponseDto reCommentCreatResponseDto = reCommentService.save(scheduleId,commentId,reCommentCreatRequestDto);

		return ResponseEntity.ok().body(reCommentCreatResponseDto);
	}

	// 2. 대댓글 수정
	@PatchMapping("/{id}")
	public ResponseEntity<ReCommentResponseDto> updateReComment(
		@PathVariable Long id,
		@RequestBody ReCommentUpdateRequestDto reCommentUpdateRequestDto
	){
		ReCommentResponseDto reCommentResponseDto = reCommentService.updateReComment(id,reCommentUpdateRequestDto);

		return ResponseEntity.ok().body(reCommentResponseDto);
	}

	// 3. 대댓글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReComment(@PathVariable Long id){
		reCommentService.delete(id);

		return ResponseEntity.ok().body(null);
	}
}
