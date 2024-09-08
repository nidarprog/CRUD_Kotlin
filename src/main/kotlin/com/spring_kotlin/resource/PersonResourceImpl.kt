package com.spring_kotlin.resource

import com.spring_kotlin.dto.AddPersonRequest
import com.spring_kotlin.dto.PersonResponse
import com.spring_kotlin.dto.UpdatePersonRequest
import com.spring_kotlin.resource.PersonResourceImpl.Companion.BASE_PERSON_URL
import com.spring_kotlin.service.PersonManagmentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonResourceImpl(private val personManagmentService: PersonManagmentService) : PersonResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<PersonResponse>? {
        val personRespone: PersonResponse? = this.personManagmentService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(personRespone)
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<PersonResponse>> = ResponseEntity.ok(this.personManagmentService.findAll())

    @PostMapping
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        val personResponse = this.personManagmentService.save(addPersonRequest)
        return ResponseEntity
            .created(URI.create(BASE_PERSON_URL.plus("/${personResponse.id}")))
            .body(personResponse)
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.ok(this.personManagmentService.update(updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.personManagmentService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}