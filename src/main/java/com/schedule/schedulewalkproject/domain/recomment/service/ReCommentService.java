package com.schedule.schedulewalkproject.domain.recomment.service;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;
import com.schedule.schedulewalkproject.domain.comment.repository.CommentRepository;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentCreatRequestDto;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentCreatResponseDto;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentResponseDto;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentUpdateRequestDto;
import com.schedule.schedulewalkproject.domain.recomment.entity.ReComment;
import com.schedule.schedulewalkproject.domain.recomment.repository.ReCommentRepository;

@Service
@RequiredArgsConstructor
public class ReCommentService {

	private final ReCommentRepository reCommentRepository;
	private final CommentRepository commentRepository;

	// 1. 대댓글 생성
	public ReCommentCreatResponseDto save(Long scheduleId,Long commentId, ReCommentCreatRequestDto reCommentCreatRequestDto) {

		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

		ReComment reComment = new ReComment(reCommentCreatRequestDto.getContent(),comment.getSchedule(),comment);


		ReComment savedRecomment = reCommentRepository.save(reComment);
		return new ReCommentCreatResponseDto(
			savedRecomment.getId(),
			savedRecomment.getContent(),
			savedRecomment.getCreatedAt()
			);
	}
	// 2. 대댓글 수정
	@Transactional
	public ReCommentResponseDto updateReComment(Long id,
		ReCommentUpdateRequestDto reCommentUpdateRequestDto) {

		ReComment reComment = reCommentRepository.findById(id)
			.orElseThrow(()-> new IllegalArgumentException("해당 대댓글이 존재하지 않습니다."));

		reComment.updateReComment(reCommentUpdateRequestDto.getContent());

		return new ReCommentResponseDto(
			reComment.getId(),
			reComment.getContent(),
			reComment.getCreatedAt(),
			reComment.getUpdatedAt()
			);

	}

	// 3. 대댓글 삭제
	@Transactional
	public void delete(Long id) {
		ReComment reComment = reCommentRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 대댓글이 존재하지 않습니다."));

		reCommentRepository.delete(reComment);

	}
}
