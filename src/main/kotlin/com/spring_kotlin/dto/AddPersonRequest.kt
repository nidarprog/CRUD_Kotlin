package com.spring_kotlin.dto

data class AddPersonRequest (
    val name: String,
    val lastName: String? = null
)