package com.spring_kotlin.service

import com.spring_kotlin.dao.PersonDao
import com.spring_kotlin.domain.Person
import com.spring_kotlin.dto.AddPersonRequest
import com.spring_kotlin.dto.PersonResponse
import com.spring_kotlin.dto.UpdatePersonRequest
import com.spring_kotlin.transformer.AddPersonRequestTransformer
import com.spring_kotlin.transformer.toPersonResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class PersonManagmentServiceImpl(private val personDao: PersonDao,
                                 private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManagmentService {
    override fun findById(id: Long): PersonResponse? = this.findPersonById(id).toPersonResponse()

    override fun findAll(): List<PersonResponse> = this.personDao.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(addPersonRequestTransformer.transform(addPersonRequest))
    }

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")
        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }
    private fun findPersonById(id: Long): Person? = this.personDao.findByIdOrNull(id)
    
    
}