package site.algosipeosseong.domain.auth.infrastructure.client.dto.request

data class GoogleOauthAccessTokenRequest(
    val code: String,
    val clientId: String,
    val clientSecret: String,
    val redirectUri: String,
    val grantType: String = "authorization_code"
)