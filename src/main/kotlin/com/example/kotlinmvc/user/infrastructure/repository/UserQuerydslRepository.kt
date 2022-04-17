package com.example.kotlinmvc.user.infrastructure.repository

import com.example.kotlinmvc.user.domain.QUser.user
import com.example.kotlinmvc.user.domain.Role
import com.example.kotlinmvc.user.domain.dto.QUserQueryDto
import com.example.kotlinmvc.user.domain.dto.UserQueryDto
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserQuerydslRepository(private val query: JPAQueryFactory) {

    fun findByRole(role: Role): List<UserQueryDto> {
        return query.select(QUserQueryDto(
            user.id,
            user.email
        )).from(user)
            .where(user.role.eq(role))
            .fetch()
    }
}