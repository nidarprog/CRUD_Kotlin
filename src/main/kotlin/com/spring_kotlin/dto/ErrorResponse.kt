package com.spring_kotlin.dto

import java.time.LocalDateTime

data class ErrorResponse(
    val title: String = "Bad request",
    val message:String,
    val dateTime: LocalDateTime = LocalDateTime.now()
)
