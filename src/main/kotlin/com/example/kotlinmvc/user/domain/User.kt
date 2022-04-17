package com.example.kotlinmvc.user.domain

import com.example.kotlinmvc.common.BaseEntity
import com.example.kotlinmvc.user.domain.dto.UserSaveDto
import javax.persistence.*


@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var email: String,
    var password: String,
    @Enumerated(EnumType.STRING)
    var role: Role,
    ) : BaseEntity() {

    constructor(userSaveDto: UserSaveDto) : this(null,userSaveDto.email,userSaveDto.password,Role.USER)
}
