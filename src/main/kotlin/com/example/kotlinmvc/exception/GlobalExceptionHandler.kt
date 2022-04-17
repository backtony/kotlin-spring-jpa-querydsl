package com.example.kotlinmvc.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException::class)
    fun applicationException(e: ApplicationException): ResponseEntity<ErrorResponse> {
        val errorResponse: ErrorResponse = if (e.errors != null) {
            ErrorResponse(e.message, e.errorCode, e.errors)
        } else {
            ErrorResponse(e.message, e.errorCode)
        }
        return ResponseEntity.status(e.httpStatus).body(errorResponse)
    }
}