package site.algosipeosseong.global.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
data class JwtProperties(
    val accessTokenKey: String,
    val refreshTokenKey: String,
    val accessExpiration: Long,
    val refreshExpiration: Long
)