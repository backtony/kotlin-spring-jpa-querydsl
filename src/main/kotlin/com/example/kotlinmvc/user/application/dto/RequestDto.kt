package com.example.kotlinmvc.user.application.dto

import com.example.kotlinmvc.user.domain.dto.UserSaveDto

data class UserSaveRequestDto(val email:String,
                              val password:String) {

    fun toUserSaveDto(): UserSaveDto {
        return UserSaveDto(email,password)
    }

}
