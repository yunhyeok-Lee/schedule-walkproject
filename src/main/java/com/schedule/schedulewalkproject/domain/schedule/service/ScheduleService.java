package com.schedule.schedulewalkproject.domain.schedule.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.schedule.schedulewalkproject.domain.comment.dto.CommentResponseDto;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;
import com.schedule.schedulewalkproject.domain.comment.repository.CommentRepository;
import com.schedule.schedulewalkproject.domain.recomment.dto.ReCommentResponseDto;
import com.schedule.schedulewalkproject.domain.recomment.entity.ReComment;
import com.schedule.schedulewalkproject.domain.recomment.repository.ReCommentRepository;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleCountResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleCreatRequestDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleCreatResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleDetailResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleListResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleUpdateRequestDto;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;
import com.schedule.schedulewalkproject.domain.schedule.repository.ScheduleRepository;

@Service // Spring Bean으로 등록
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;
	private final CommentRepository commentRepository;
	private final ReCommentRepository reCommentRepository;

	// 1. 일정 생성 service
	public ScheduleCreatResponseDto save(ScheduleCreatRequestDto scheduleRequestDto) {

		Schedule schedule = new Schedule(scheduleRequestDto.getTitle(), scheduleRequestDto.getContent());

		Schedule savedSchedule = scheduleRepository.save(schedule);

		return new ScheduleCreatResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContent(),
			savedSchedule.getCreatedAt(), savedSchedule.getUpdatedAt());

	}
	/*
	 * 2. 일정 전체 조회
	 * DB에서 모든 Schedule 데이터를 전체 조회해서 List에 저장
	 * 조회한 Schedule 엔티티 리스트를  Dto List로 변환 (stream 사용)
	 * 일정 목록 조회 시, 각 일정마다 댓글 개수 조회
	 */

	public ScheduleListResponseDto findAll() {
		List<Schedule> schedules = scheduleRepository.findAll();

		// List<ScheduleResponseDto> scheduleDtos = schedules.stream()
		// 	.map(schedule -> new ScheduleResponseDto(
		// 		// 각 Schedule 객체를 -> ScheduleResponseDto 객체로 변환
		// 		schedule.getId(),
		// 		schedule.getTitle(),
		// 		schedule.getContent(),
		// 		schedule.getCreatedAt(),
		// 		schedule.getUpdatedAt()
		// 	))
		// 	.collect(Collectors.toList()); // 변환된 dto 객체들을 전부 리스트로 모아준다.
		// return new ScheduleListResponseDto(scheduleDtos);


		List<ScheduleCountResponseDto> scheduleCountResponseDtos = schedules.stream()
			.map(schedule -> {
				Long commentCount = commentRepository.countByScheduleId(schedule.getId());
					return new ScheduleCountResponseDto(
						schedule.getId(),
						schedule.getTitle(),
						schedule.getContent(),
						schedule.getCreatedAt(),
						schedule.getUpdatedAt(),
						commentCount
					);
			})
			.collect(Collectors.toList());

		return new ScheduleListResponseDto(scheduleCountResponseDtos);
	}

	/*
	 * 3. 일정 단건 조회 (상세 조회)
	 * 일정 상세 조회 시, 해당 일정에 작성된 모든 댓글 목록을 함께 조회
	 * 댓글 목록은 작성일 기준 오름차순 (작성 오래된 순)으로 정렬
	 */
	// public ScheduleResponseDto findbyId(Long id) {
	//
	// 	 Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
	//
	//
	//
	// 	 if(optionalSchedule.isEmpty()){
	// 		 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	// 	 }
	//
	// 	 Schedule findschedule = optionalSchedule.get();
	//
	// 	return new ScheduleResponseDto(
	// 		findschedule.getId(),
	// 		findschedule.getTitle(),
	// 		findschedule.getContent(),
	// 		findschedule.getCreatedAt(),
	// 		findschedule.getUpdatedAt()
	// 	);

	public ScheduleDetailResponseDto findbyId(Long id) {
		Schedule schedule = scheduleRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		List<Comment> comments = commentRepository.findByScheduleIdOrderByContentAsc(id);

		List<CommentResponseDto> commentResponseDtos = comments.stream()
			.map(comment -> {
				// 대댓글 가져오기
				List<ReComment> reComments = reCommentRepository.findByParentcommentIdOrderByCreatedAtAsc(id);

				List<ReCommentResponseDto> reCommentResponseDtos = reComments.stream()
					.map(reComment -> new ReCommentResponseDto(
						reComment.getId(),
						reComment.getContent(),
						reComment.getCreatedAt(),
						reComment.getUpdatedAt()
					))
					.collect(Collectors.toList());

				return new CommentResponseDto(
					comment.getId(),
					comment.getContent(),
					comment.getCreatedAt(),
					comment.getUpdatedAt(),
					reCommentResponseDtos
				);

			})
			.collect(Collectors.toList());
		return new ScheduleDetailResponseDto(
			schedule.getId(),
			schedule.getTitle(),
			schedule.getContent(),
			schedule.getCreatedAt(),
			schedule.getUpdatedAt(),
			commentResponseDtos
		);

		// List<CommentResponseDto> commentResponseDtos = comments.stream()
		// 	.map(comment -> new CommentResponseDto(
		// 		comment.getId(),
		// 		comment.getContent(),
		// 		comment.getCreatedAt(),
		// 		comment.getUpdatedAt()
		// 	))
		// 	.collect(Collectors.toList());
		//
		// return new ScheduleDetailResponseDto(
		// 	schedule.getId(),
		// 	schedule.getTitle(),
		// 	schedule.getContent(),
		// 	schedule.getCreatedAt(),
		// 	schedule.getUpdatedAt(),
		// 	commentResponseDtos
		// );

	}

	/*
	 4. 일정 수정
	 */
	@Transactional
	public ScheduleResponseDto updateSchedule(Long id ,ScheduleUpdateRequestDto scheduleUpdateRequestDto) {

		Schedule schedule = scheduleRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

		schedule.updateSchedule(scheduleUpdateRequestDto.getTitle(), scheduleUpdateRequestDto.getContent());

		return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(),schedule.getContent(),schedule.getCreatedAt(),schedule.getUpdatedAt());
	}

	/*
	 5. 일정 삭제
	 */
	public void delete(Long id) {
		Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

		 scheduleRepository.delete(schedule);

	}

}
