package com.schedule.schedulewalkproject.domain.schedule.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleCreatRequestDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleCreatResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleListResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleResponseDto;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;
import com.schedule.schedulewalkproject.domain.schedule.repository.ScheduleRepository;

@Service // Spring Bean으로 등록
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;

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
	 */

	public ScheduleListResponseDto findAll() {
		List<Schedule> schedules = scheduleRepository.findAll();

		List<ScheduleResponseDto> scheduleDtos = schedules.stream()
			.map(schedule -> new ScheduleResponseDto(
				// 각 Schedule 객체를 -> ScheduleResponseDto 객체로 변환
				schedule.getId(),
				schedule.getTitle(),
				schedule.getContent(),
				schedule.getCreatedAt(),
				schedule.getUpdatedAt()
			))
			.collect(Collectors.toList()); // 변환된 dto 객체들을 전부 리스트로 모아준다.
		return new ScheduleListResponseDto(scheduleDtos);
	}

	/*
	 3. 일정 단건 조회
	 */
	public ScheduleResponseDto findbyId(Long id) {
		Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

		Schedule schedule = optionalSchedule.get();

		return new ScheduleResponseDto(
			schedule.getId(),
			schedule.getTitle(),
			schedule.getContent(),
			schedule.getCreatedAt(),
			schedule.getUpdatedAt()
		);
	}

	/*
	 4. 일정 수정
	 */
	public ScheduleCreatResponseDto update(ScheduleCreatRequestDto scheduleRequestDto) {
		return null;
	}

	/*
	 5. 일정 삭제
	 */
	public void delete(Long id) {

	}

}
