package com.example.kotlinmvc.user.domain

enum class Role(val key: String, val title: String) {
    USER("ROLE_USER", "사용자"),
    ADMIN("ROLE_ADMIN", "관리자")
}
