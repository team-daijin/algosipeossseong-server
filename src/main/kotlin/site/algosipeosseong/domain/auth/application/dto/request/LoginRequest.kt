package site.algosipeosseong.domain.auth.application.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank(message = "필수 값입니다")
    @field:Email(message = "이메일 형식 이여야 합니다.")
    val email: String,
    @field:NotBlank(message = "필수 값입니다.")
    val password: String
)