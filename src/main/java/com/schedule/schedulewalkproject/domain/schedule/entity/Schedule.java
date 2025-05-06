package com.schedule.schedulewalkproject.domain.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;

import com.schedule.schedulewalkproject.common.entity.BaseEntity;
import com.schedule.schedulewalkproject.domain.schedule.dto.ScheduleUpdateRequestDto;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	// @ManyToOne
	// @JoinColumn(name = "user_id")
	// private User user;

	public Schedule() {

	}

	public Schedule(String title, String content) {
		this.title = title;
		this.content = content;
	}

	// update
	public void updateSchedule(String title, String content){
		this.title =title;
		this.content = content;
	}

	public void delete(Schedule schedule) {

	}
}
