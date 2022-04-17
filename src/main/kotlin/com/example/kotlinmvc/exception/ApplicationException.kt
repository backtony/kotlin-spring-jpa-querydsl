package com.example.kotlinmvc.exception

import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult

abstract class ApplicationException: RuntimeException {

    val errorCode: String
    val httpStatus: HttpStatus
    val errors:BindingResult?

    protected constructor(errorCode: String,httpStatus: HttpStatus,message: String): super(message){
        this.errorCode = errorCode
        this.httpStatus = httpStatus
        this.errors=null
    }

    protected constructor(errorCode: String, httpStatus: HttpStatus, message: String, errors: BindingResult) : super(
        message) {
        this.errorCode = errorCode
        this.httpStatus = httpStatus
        this.errors = errors
    }

}