package com.schedule.schedulewalkproject.domain.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
	// Long id(Long id);

}
