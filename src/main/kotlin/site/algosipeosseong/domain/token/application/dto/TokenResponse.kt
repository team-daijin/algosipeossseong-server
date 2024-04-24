package site.algosipeosseong.domain.token.application.dto

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)