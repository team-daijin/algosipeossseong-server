package site.algosipeosseong.domain.auth.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.token.application.dto.TokenResponse
import site.algosipeosseong.domain.auth.infrastructure.GoogleAuthService
import site.algosipeosseong.domain.auth.infrastructure.client.GoogleOauthClient
import site.algosipeosseong.domain.token.application.TokenService
import site.algosipeosseong.domain.user.domain.User
import site.algosipeosseong.domain.user.domain.constant.Role
import site.algosipeosseong.domain.user.infrastructure.UserRepository
import site.algosipeosseong.global.config.property.GoogleOAuthProperties

@Component
class GoogleAuthUseCase(
    private val googleOauthClient: GoogleOauthClient,
    private val tokenService: TokenService,
    private val properties: GoogleOAuthProperties,
    private val userRepository: UserRepository,
    private val googleAuthService: GoogleAuthService
) {
    fun execute(code: String): TokenResponse {
        val accessToken = googleAuthService.getAccessToken(code, properties.redirectUri)

        val response = googleOauthClient.getUserInformation(accessToken)

        val user = userRepository.findByEmail(response.email) ?:
            userRepository.save(
                User(
                    accountId = response.name,
                    email = response.email,
                    role = Role.USER
                )
            )

        return TokenResponse(
            accessToken = tokenService.generateAccessToken(user.id!!),
            refreshToken = tokenService.generateRefreshToken(user.id)
        )
    }
}