package site.algosipeosseong.domain.auth.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.auth.application.dto.request.LoginRequest
import site.algosipeosseong.domain.token.application.dto.TokenResponse
import site.algosipeosseong.domain.auth.exception.MismatchesUserPasswordException
import site.algosipeosseong.domain.auth.exception.NotFoundUserEmailException
import site.algosipeosseong.domain.token.application.TokenService
import site.algosipeosseong.domain.user.infrastructure.UserRepository
import site.algosipeosseong.global.util.PasswordUtil

@Component
class LoginUseCase(
    private val userRepository: UserRepository,
    private val tokenService: TokenService
) {
    fun execute(
        request: LoginRequest
    ): TokenResponse {
        val user = userRepository.findByEmail(request.email) ?: throw NotFoundUserEmailException

        if (!PasswordUtil.matches(request.password, user.password!!.value)) {
            throw MismatchesUserPasswordException
        }

        return TokenResponse(
            accessToken = tokenService.generateAccessToken(user.id!!),
            refreshToken = tokenService.generateRefreshToken(user.id)
        )
    }
}