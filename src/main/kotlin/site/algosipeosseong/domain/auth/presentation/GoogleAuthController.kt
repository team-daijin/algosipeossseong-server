package site.algosipeosseong.domain.auth.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import site.algosipeosseong.domain.auth.application.GoogleAuthUseCase
import site.algosipeosseong.domain.token.application.dto.TokenResponse
import site.algosipeosseong.domain.auth.infrastructure.GoogleAuthService

@RestController
@RequestMapping("/auth/google")
class GoogleAuthController(
    private val googleAuthUseCase: GoogleAuthUseCase,
    private val googleAuthService: GoogleAuthService
){
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getGoogleOAuthLink(): String {
        return googleAuthService.getOauthLink()
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    fun loginWithGoogle(
        @RequestParam code: String
    ): TokenResponse {
        return googleAuthUseCase.execute(code)
    }
}