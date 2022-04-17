package com.example.kotlinmvc.user.application

import com.example.kotlinmvc.user.application.dto.UserInfoResponseDto
import com.example.kotlinmvc.user.application.dto.UserQueryResponseDto
import com.example.kotlinmvc.user.domain.Role

interface UserQueryUseCase {
    fun findByEmail(email: String) : UserInfoResponseDto

    fun findByRole(role: Role) : List<UserQueryResponseDto>
}