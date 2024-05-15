package site.algosipeosseong.domain.auth.infrastructure

import org.springframework.stereotype.Service
import site.algosipeosseong.global.config.property.GoogleOAuthProperties
import site.algosipeosseong.domain.auth.application.OAuthService
import site.algosipeosseong.domain.auth.infrastructure.client.GoogleOauthClient
import site.algosipeosseong.domain.auth.infrastructure.client.dto.request.GoogleOauthAccessTokenRequest

@Service
class GoogleAuthService(
    private val properties: GoogleOAuthProperties,
    private val client: GoogleOauthClient
): OAuthService {
    override fun getOauthLink(): String {
        return properties.baseUrl + "?client_id=${properties.clientId}&redirect_uri=${properties.redirectUri}&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile"
    }

    override fun getAccessToken(code: String, redirectUri: String): String {
        val accessToken = client.getAccessToken(
            GoogleOauthAccessTokenRequest(
                code = code,
                clientId = properties.clientId,
                clientSecret = properties.clientSecret,
                redirectUri = redirectUri,
            )
        ).accessToken

        return accessToken
    }

}