package com.schedule.schedulewalkproject.domain.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;

import com.schedule.schedulewalkproject.common.entity.BaseEntity;

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

	public Schedule() {

	}

	public Schedule(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

}
