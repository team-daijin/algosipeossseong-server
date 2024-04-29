package site.algosipeosseong.domain.auth.presentation

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import site.algosipeosseong.domain.auth.application.LoginUseCase
import site.algosipeosseong.domain.auth.application.dto.request.LoginRequest
import site.algosipeosseong.domain.token.application.dto.TokenResponse

@RestController
@RequestMapping("/auth")
class AuthController(
    private val loginUseCase: LoginUseCase
) {
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(
        @RequestBody @Valid request: LoginRequest
    ): TokenResponse {
        return loginUseCase.execute(request)
    }
}