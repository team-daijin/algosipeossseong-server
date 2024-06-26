package site.algosipeosseong.domain.token.infrastructure

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import site.algosipeosseong.domain.token.application.TokenService
import site.algosipeosseong.domain.token.domain.RefreshToken
import site.algosipeosseong.domain.token.domain.constant.TokenType
import site.algosipeosseong.domain.token.exception.ExpiredTokenException
import site.algosipeosseong.domain.token.exception.InvalidTokenException
import site.algosipeosseong.global.config.property.JwtProperties
import java.lang.Exception
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*

@Service
class TokenServiceImpl(
    private val properties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
): TokenService {
    override fun generateAccessToken(id: Long): String {
        return generateToken(id, TokenType.ACCESS_TOKEN, properties.accessExpiration)
    }

    override fun generateRefreshToken(id: Long): String {
        val refreshToken = generateToken(id, TokenType.REFRESH_TOKEN, properties.refreshExpiration)
        refreshTokenRepository.save(
            RefreshToken(
                token = refreshToken,
                ttl = properties.refreshExpiration
            )
        )
        return refreshToken
    }

    override fun getTokenFromHeader(header: String?): String? {
        if(header != null && header.startsWith("Bearer ")) {
            return header.replace("Bearer ", "")
        }

        return null
    }

    override fun extractIdFromToken(token: String): String {
        return extractAllClaims(token)["id"].toString()
    }

    private fun generateToken(id: Long, tokenType: TokenType, time: Long): String {
        val claims = Jwts.claims().apply {
            this["id"] = id
            this["type"] = tokenType.value
        }

        val now = Date()

        val secretKey = when(tokenType) {
            TokenType.ACCESS_TOKEN -> properties.accessTokenKey
            TokenType.REFRESH_TOKEN -> properties.refreshTokenKey
        }

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + time))
            .signWith(getSigningKey(secretKey), SignatureAlgorithm.HS256)
            .compact()
    }

    private fun extractAllClaims(token: String): Claims {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(properties.accessTokenKey))
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredTokenException) {
            throw ExpiredTokenException
        } catch (e: Exception) {
            throw InvalidTokenException
        }
    }

    private fun getSigningKey(secretKey: String): Key {
        val keyBytes: ByteArray = secretKey.toByteArray(StandardCharsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }

}