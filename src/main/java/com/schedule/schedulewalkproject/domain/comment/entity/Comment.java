package com.schedule.schedulewalkproject.domain.comment.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;

import com.schedule.schedulewalkproject.common.entity.BaseEntity;
import com.schedule.schedulewalkproject.domain.recomment.entity.ReComment;
import com.schedule.schedulewalkproject.domain.schedule.entity.Schedule;

@Entity
@Getter
@Table(name = "comment")
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id",nullable = false)
	private Schedule schedule;

	@OneToMany(mappedBy = "parentcomment", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReComment> reComments = new ArrayList<>();

	public Comment(){
	}

	public Comment(String content, Schedule schedule){
		this.content = content;
		this.schedule = schedule;
	}

	//update
	public void updateComment(String content){
		this.content = content;
	}

}
