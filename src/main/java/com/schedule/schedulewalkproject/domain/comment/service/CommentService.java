package com.schedule.schedulewalkproject.domain.comment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatRequestDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentListResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentUpdateRequestDto;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;
import com.schedule.schedulewalkproject.domain.comment.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;

	/*
	 * 1. 댓글 작성
	 * scheduleId 값에 따라 댓글 작성
	 */
	public CommentCreatResponseDto save(Long scheduleId, CommentCreatRequestDto commentCreatRequestDto) {

		Comment comment = new Comment(commentCreatRequestDto.getContent());

		Comment savedComment = commentRepository.save(comment);

		return new CommentCreatResponseDto(savedComment.getId(), savedComment.getContent(), savedComment.getCreatedAt(),
			savedComment.getUpdatedAt());

	}

	/*
	 * 2. 댓글 조회
	 * 스케줄 조회 시 댓글도 같이 조회
	 */
	public CommentListResponseDto findAll() {

		List<Comment> commentList = commentRepository.findAll();

		List<CommentResponseDto> commentResponseDtos = commentList.stream()
			.map(comment -> new CommentResponseDto(
				comment.getId(),
				comment.getContent(),
				comment.getCreatedAt(),
				comment.getUpdatedAt()
			))
			.collect(Collectors.toList());
		return new CommentListResponseDto(commentResponseDtos);
	}

	/*
	 * 3. 댓글 상세 조회
	 */
	public CommentResponseDto findbyId(Long id) {

		Optional<Comment> optionalComment = commentRepository.findById(id);

		if (optionalComment.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		Comment findcomment = optionalComment.get();
		return new CommentResponseDto(
			findcomment.getId(),
			findcomment.getContent(),
			findcomment.getCreatedAt(),
			findcomment.getUpdatedAt()
		);
	}
	/*
	 * 3. 댓글 수정
	 */
	public CommentResponseDto updateComment(Long id, CommentUpdateRequestDto commentUpdateRequestDto) {

	Comment comment = commentRepository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

	comment.updateComment(commentUpdateRequestDto.getContent());
	return new CommentResponseDto(comment.getId(),comment.getContent(),comment.getCreatedAt(),comment.getUpdatedAt());
	}


}
