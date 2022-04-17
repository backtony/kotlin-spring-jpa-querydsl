package com.example.kotlinmvc.user.application

import com.example.kotlinmvc.user.application.dto.UserSaveRequestDto

interface UserCommandUseCase {
    fun saveUser(userSaveRequestDto: UserSaveRequestDto)
}