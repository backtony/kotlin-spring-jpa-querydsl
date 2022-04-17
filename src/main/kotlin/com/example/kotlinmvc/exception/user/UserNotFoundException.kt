package com.example.kotlinmvc.exception.user

import org.springframework.http.HttpStatus

class UserNotFoundException : UserException(code,HttpStatus.BAD_REQUEST, message) {

    companion object {
        private const val message: String = "존재하지 않는 회원입니다."
        private const val code: String = "LOGIN-400"
    }
}