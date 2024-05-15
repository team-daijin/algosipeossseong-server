package site.algosipeosseong.domain.auth.application

interface OAuthService {
    fun getOauthLink(): String
    fun getAccessToken(code: String, redirectUri: String): String
}