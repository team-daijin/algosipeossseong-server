package site.algosipeosseong.domain.user.application.dto

import site.algosipeosseong.domain.user.domain.constant.Gender

data class SignUpUserRequest(
    val accountId: String,
    val email: String,
    val password: String,
    val name: String,
    val age: String,
    val gender: Gender
)
