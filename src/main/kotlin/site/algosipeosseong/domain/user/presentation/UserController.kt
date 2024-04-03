package site.algosipeosseong.domain.user.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import site.algosipeosseong.domain.user.application.SignUpUserUseCase
import site.algosipeosseong.domain.user.application.dto.SignUpUserRequest

@RestController
@RequestMapping("/user")
class UserController(
    private val signUpUserUseCase: SignUpUserUseCase
) {
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(
        @RequestBody request: SignUpUserRequest
    ) {
        signUpUserUseCase.execute(request)
    }
}
