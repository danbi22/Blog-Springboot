package com.example.demo.repository;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 여러 테이블에서 공통으로 사용되는 생성시간을 프로퍼티로 갖는 객체

@Getter
@MappedSuperclass
// -> 다른 도메인(엔터티) 클래스의 상위 클래스로 사용됨.
// -> 상속하는 하위 클래스는 BaseTimeEntity가 정의하는 컬럼을 갖게 됨.
@EntityListeners(AuditingEntityListener.class)
// -> main 메서드를 갖고 있는 메인 클래스(PostApplication)에서 JPA Auditing 기능이 활성화 되어 있는 경우
// -> 엔터티가 삽입/수정되는 시간이 자동으로 기록되기 위해서
public class BaseTimeEntity {

    /**
     * 엔터티 클래스의 필드 이름은 데이터베이스 테이블의 컬럼 이름과 같거나,
     * 컬럼 이름을 camel 표기법으로 변환한 이름으로 작성
     * (예) 테이블 컬럼 created_time - 테이블 필드 createdTime
     */

    @CreatedDate // insert될 때의 시간이 자동으로 기록됨.
    private LocalDateTime createdTime;
    // 엔티티 클래스의 필드 이름은 자바의 관습(camel 표기법)으로 작성
    // 테이블의 컬럼 이름은 데이터베이스의 관습(snake 표기법)으로 작성
}
