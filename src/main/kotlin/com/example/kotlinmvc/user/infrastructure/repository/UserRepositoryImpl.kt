package com.example.kotlinmvc.user.infrastructure.repository

import com.example.kotlinmvc.user.domain.Role
import com.example.kotlinmvc.user.domain.User
import com.example.kotlinmvc.user.domain.UserRepository
import com.example.kotlinmvc.user.domain.dto.UserQueryDto
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(val userJpaRepository: UserJpaRepository,
                         val userQuerydslRepository: UserQuerydslRepository) : UserRepository {

    override fun save(user: User) {
        userJpaRepository.save(user)
    }

    override fun findByEmail(email: String): User? {
        return userJpaRepository.findByEmail(email)
    }

    override fun findUserQueryDtoByRole(role: Role): List<UserQueryDto> {
        return userQuerydslRepository.findByRole(role)
    }


}