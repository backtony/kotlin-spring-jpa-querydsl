package com.example.kotlinmvc.user.presentation.dto

import com.example.kotlinmvc.user.application.dto.UserInfoResponseDto
import com.example.kotlinmvc.user.application.dto.UserQueryResponseDto
import com.example.kotlinmvc.user.domain.Role

data class UserInfoResponse(val email:String, val role: Role){
    constructor(userInfoResponseDto: UserInfoResponseDto): this(userInfoResponseDto.email,userInfoResponseDto.role)
}

data class UserQueryResponse(val id:Long, val email:String){
    constructor(userQueryResponseDto: UserQueryResponseDto): this(userQueryResponseDto.id, userQueryResponseDto.email)
}

data class UserQueryResponseList(val userQueryResponseList: List<UserQueryResponse>)

