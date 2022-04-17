package com.example.kotlinmvc.user.infrastructure.repository

import com.example.kotlinmvc.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User,Long>{

    fun findByEmail(email:String): User?
}