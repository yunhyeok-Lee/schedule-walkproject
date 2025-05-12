package com.schedule.schedulewalkproject.domain.recomment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schedule.schedulewalkproject.domain.recomment.entity.ReComment;

public interface ReCommentRepository extends JpaRepository<ReComment, Long> {
}
