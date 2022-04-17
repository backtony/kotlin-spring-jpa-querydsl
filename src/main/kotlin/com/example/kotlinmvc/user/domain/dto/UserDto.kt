package com.example.kotlinmvc.user.domain.dto

import com.querydsl.core.annotations.QueryProjection

data class UserSaveDto(
    val email: String,
    val password: String,
)

data class UserQueryDto @QueryProjection constructor(
    val id: Long,
    val email: String
)
