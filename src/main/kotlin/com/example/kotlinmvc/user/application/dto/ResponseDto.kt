package com.example.kotlinmvc.user.application.dto

import com.example.kotlinmvc.user.domain.Role
import com.example.kotlinmvc.user.domain.dto.UserQueryDto

data class UserInfoResponseDto(val email:String, val role: Role)

data class UserQueryResponseDto(val id:Long, val email:String){
    constructor(userQueryDto: UserQueryDto) : this(userQueryDto.id,userQueryDto.email)
}
