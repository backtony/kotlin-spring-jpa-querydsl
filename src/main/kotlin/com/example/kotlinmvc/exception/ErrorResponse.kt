package com.example.kotlinmvc.exception

import org.springframework.validation.BindingResult
import java.util.stream.Collectors

data class ErrorResponse(
    var message: String? = null,
    var code: String = "",
    var errors: List<FieldError> = mutableListOf(),
) {

    constructor(message: String?, code: String, result: BindingResult) : this(message,
        code,
        FieldError.from(result))


    class FieldError private constructor(
        private val field: String,
        private val value: String,
        private val reason: String,
    ) {
        companion object {
            fun from(bindingResult: BindingResult): List<FieldError> {
                val fieldErrors = bindingResult.fieldErrors
                return fieldErrors.stream()
                    .map { error: org.springframework.validation.FieldError ->
                        FieldError(
                            error.field,
                            if (error.rejectedValue == null) "" else error.rejectedValue.toString(),
                            error.defaultMessage!!
                        )
                    }
                    .collect(Collectors.toList())
            }
        }
    }
}
