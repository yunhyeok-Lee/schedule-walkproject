package com.schedule.schedulewalkproject.domain.comment.service;

import java.util.Collections;
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
import com.schedule.schedulewalkproject.domain.recomment.entity.ReComment;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;
import com.schedule.schedulewalkproject.domain.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final ScheduleRepository scheduleRepository;

	/*
	 * 1. 댓글 작성
	 * scheduleId 값에 따라 댓글 작성
	 */
	public CommentCreatResponseDto save(Long scheduleId, CommentCreatRequestDto commentCreatRequestDto) {

		Schedule schedule = scheduleRepository.findById(scheduleId)
			.orElseThrow(()-> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

		Comment comment = new Comment(commentCreatRequestDto.getContent(), schedule);

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
				comment.getUpdatedAt(),
				Collections.emptyList()
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
			findcomment.getUpdatedAt(),
			Collections.emptyList()
		);
	}
	/*
	 * 4. 댓글 수정
	 */
	public CommentResponseDto updateComment(Long id, CommentUpdateRequestDto commentUpdateRequestDto) {

	Comment comment = commentRepository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

	comment.updateComment(commentUpdateRequestDto.getContent());
	return new CommentResponseDto(comment.getId(),comment.getContent(),comment.getCreatedAt(),comment.getUpdatedAt(),Collections.emptyList());
	}

	/*
	 * 5. 댓글 삭제
	 */
	public void delete(Long id) {
		Comment comment = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

		commentRepository.delete(comment);

	}
}
