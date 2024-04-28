package site.algosipeosseong.domain.auth.application.dto.request

data class LoginRequest(
    val email: String,
    val password: String
)