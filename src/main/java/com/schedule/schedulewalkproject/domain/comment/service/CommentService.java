package com.schedule.schedulewalkproject.domain.comment.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatRequestDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentCreatResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentListResponseDto;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentResponseDto;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;
import com.schedule.schedulewalkproject.domain.comment.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;

	// 1. 댓글 작성
	public CommentCreatResponseDto save(Long scheduleId, CommentCreatRequestDto commentCreatRequestDto) {

		Comment comment = new Comment(commentCreatRequestDto.getContent());

		Comment savedComment = commentRepository.save(comment);

		return new CommentCreatResponseDto(savedComment.getId(), savedComment.getContent(), savedComment.getCreatedAt(),
			savedComment.getUpdatedAt());

	}

	// 2. 댓글 조회
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
}
