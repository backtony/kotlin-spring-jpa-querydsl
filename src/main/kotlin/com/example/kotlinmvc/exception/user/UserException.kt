package com.example.kotlinmvc.exception.user

import com.example.kotlinmvc.exception.ApplicationException
import org.springframework.http.HttpStatus

abstract class UserException protected constructor(errorCode:String,httpStatus: HttpStatus,message: String)
    :ApplicationException(errorCode,httpStatus,message){
}