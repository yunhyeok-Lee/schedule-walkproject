package com.schedule.schedulewalkproject.domain.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	/*
	 * 댓글 작성일 오래된 순으로 정렬
	 */
	List<Comment> findByScheduleIdOrderByContentAsc(Long scheduleId);
}
