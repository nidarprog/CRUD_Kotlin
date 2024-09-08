package com.spring_kotlin.transformer

import com.spring_kotlin.domain.Person
import com.spring_kotlin.dto.PersonResponse

    fun Person?.toPersonResponse(): PersonResponse{
        return PersonResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.lastName}, ${this?.name}"
        )
    }
