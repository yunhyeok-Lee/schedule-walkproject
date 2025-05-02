package com.schedule.schedulewalkproject.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * abstract class 로 하는 이유는 상속 받아서 사용하도록 제한하기 위해
 */
@Getter
@MappedSuperclass // JPA에서 공통 매핑 정보를 상속받을 때 사용하는 어노테이션
@EntityListeners(AuditingEntityListener.class) // 엔티티의 생성시점이나 수정 시점에 자동으로 특정 작업을 해주기위해 사용 (시간 작업)
public abstract class BaseEntity {

	@CreatedDate
	@Column(updatable = false) // 생성 시간 수정 불가능
	private LocalDateTime createdAt;

	@LastModifiedDate // 마지막으로 수정한 시간으로 업데이트
	private LocalDateTime updatedAt;

}
