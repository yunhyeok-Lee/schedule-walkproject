package com.schedule.schedulewalkproject.domain.schedule.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;

import com.schedule.schedulewalkproject.common.entity.BaseEntity;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;

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

	/*
	 * Comment 테이블에 schedule_id 외래키 존재
	 * Schedule 에서 List<Comment> 관리
	 */
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();

	public Schedule() {

	}

	public Schedule(String title, String content) {
		this.title = title;
		this.content = content;
	}

	// update
	public void updateSchedule(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public void delete(Schedule schedule) {

	}
}
