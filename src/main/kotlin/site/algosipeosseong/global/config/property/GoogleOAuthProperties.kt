package site.algosipeosseong.global.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("oauth.google")
data class GoogleOAuthProperties(
    val baseUrl: String,
    val clientId: String,
    val clientSecret: String,
    val redirectUri: String
)