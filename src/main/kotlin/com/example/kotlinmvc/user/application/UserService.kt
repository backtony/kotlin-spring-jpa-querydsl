package com.example.kotlinmvc.user.application

import com.example.kotlinmvc.exception.user.UserNotFoundException
import com.example.kotlinmvc.user.application.dto.UserInfoResponseDto
import com.example.kotlinmvc.user.application.dto.UserQueryResponseDto
import com.example.kotlinmvc.user.application.dto.UserSaveRequestDto
import com.example.kotlinmvc.user.domain.Role
import com.example.kotlinmvc.user.domain.User
import com.example.kotlinmvc.user.domain.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository
) : UserCommandUseCase, UserQueryUseCase {

    @Transactional
    override fun saveUser(UserSaveRequestDto: UserSaveRequestDto) {
        val userSaveDto = UserSaveRequestDto.toUserSaveDto()
        userRepository.save(User(userSaveDto))
    }

    override fun findByEmail(email: String) : UserInfoResponseDto{
        return userRepository.findByEmail(email)?.let {
            UserInfoResponseDto(it.email, it.role)
        } ?: throw UserNotFoundException()
    }

    override fun findByRole(role: Role): List<UserQueryResponseDto> {
        return userRepository.findUserQueryDtoByRole(role).map { UserQueryResponseDto(it) }
    }

}