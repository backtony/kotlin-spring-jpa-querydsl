package com.example.kotlinmvc.user.domain

import com.example.kotlinmvc.user.domain.dto.UserQueryDto

interface UserRepository {

    fun save(user: User)

    fun findByEmail(email: String): User?

    fun findUserQueryDtoByRole(role:Role): List<UserQueryDto>
}