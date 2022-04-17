package com.example.kotlinmvc.user.presentation.dto

import com.example.kotlinmvc.user.application.dto.UserSaveRequestDto

data class UserSaveRequest(
    val email: String,
    val password: String,
) {
    fun toUserSaveRequestDto(): UserSaveRequestDto {
        return UserSaveRequestDto(email, password)
    }
}