package com.spring_kotlin.transformer

import com.spring_kotlin.domain.Person
import com.spring_kotlin.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer: Transformer<AddPersonRequest, Person>{
    override fun transform(source: AddPersonRequest): Person {
        return Person(
            name = source.name,
            lastName = source.lastName
        )
    }
}