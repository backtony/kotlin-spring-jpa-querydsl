package com.example.kotlinmvc.user.presentation

import com.example.kotlinmvc.user.application.UserCommandUseCase
import com.example.kotlinmvc.user.application.UserQueryUseCase
import com.example.kotlinmvc.user.domain.Role
import com.example.kotlinmvc.user.presentation.dto.UserInfoResponse
import com.example.kotlinmvc.user.presentation.dto.UserQueryResponse
import com.example.kotlinmvc.user.presentation.dto.UserQueryResponseList
import com.example.kotlinmvc.user.presentation.dto.UserSaveRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserRestController(
    private val userCommandUseCase: UserCommandUseCase,
    private val userQueryUseCase: UserQueryUseCase,
) {

    @PostMapping
    fun saveUser(@RequestBody userSaveRequest: UserSaveRequest): ResponseEntity<Unit> {
        userCommandUseCase.saveUser(userSaveRequest.toUserSaveRequestDto())
        return ResponseEntity.ok().build()
    }

    @GetMapping()
    fun getUser(@RequestParam email: String): ResponseEntity<UserInfoResponse> {
        return ResponseEntity.ok(UserInfoResponse(userQueryUseCase.findByEmail(email)))
    }

    @GetMapping("/query")
    fun getUser(@RequestParam role: Role): ResponseEntity<UserQueryResponseList> {
        return ResponseEntity.ok(UserQueryResponseList(userQueryUseCase.findByRole(role).map { UserQueryResponse(it) }))
    }


}