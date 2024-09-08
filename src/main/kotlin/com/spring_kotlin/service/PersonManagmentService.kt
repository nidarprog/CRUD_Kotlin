package com.spring_kotlin.service

import com.spring_kotlin.dto.AddPersonRequest
import com.spring_kotlin.dto.PersonResponse
import com.spring_kotlin.dto.UpdatePersonRequest

interface PersonManagmentService {
    fun findById(id: Long): PersonResponse?
    fun findAll(): List<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long): Unit
}