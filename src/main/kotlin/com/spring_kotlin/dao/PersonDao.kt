package com.spring_kotlin.dao

import com.spring_kotlin.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao: JpaRepository<Person, Long> {
}