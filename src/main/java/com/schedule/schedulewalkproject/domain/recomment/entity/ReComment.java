package com.schedule.schedulewalkproject.domain.recomment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;

import com.schedule.schedulewalkproject.common.entity.BaseEntity;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;

@Entity
@Getter
@Table(name = "recomment")
public class ReComment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String content;

	@ManyToOne
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;

	@ManyToOne
	@JoinColumn(name = "comment_id", nullable = false)
	private Comment parentcomment;

	public ReComment() {
	}

	public ReComment(String content, Schedule schedule, Comment parentcomment) {
		this.content = content;
		this.schedule = schedule;
		this.parentcomment = parentcomment;
	}

	// update
	public void updateReComment(String content){
		this.content = content;
	}
}
