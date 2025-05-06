package com.schedule.schedulewalkproject.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schedule.schedulewalkproject.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
