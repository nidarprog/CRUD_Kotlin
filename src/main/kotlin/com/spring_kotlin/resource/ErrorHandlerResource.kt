package com.spring_kotlin.resource

import com.spring_kotlin.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandlerResource {

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(ex: IllegalStateException): ResponseEntity<ErrorResponse>{
        return ResponseEntity.badRequest().body(ErrorResponse(message = ex.localizedMessage))
    }
}