package site.algosipeosseong.domain.user.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.user.application.dto.SignUpUserRequest
import site.algosipeosseong.domain.user.domain.User
import site.algosipeosseong.domain.user.domain.constant.Role
import site.algosipeosseong.domain.user.infrastructure.UserRepository
import site.algosipeosseong.domain.user.domain.value.Password
import site.algosipeosseong.domain.user.domain.value.Privacy
import site.algosipeosseong.global.util.PasswordUtil

@Component
class SignUpUserUseCase(
    private val userRepository: UserRepository
) {
    fun execute(request: SignUpUserRequest) {
        if (userRepository.existsByEmail(request.email)) throw RuntimeException("이미 존재하는 이메일입니다.")
        userRepository.save(
            User(
                accountId = request.accountId,
                email = request.email,
                password = Password.of(PasswordUtil.encoded(request.password)),
                privacy = Privacy(
                    request.name,
                    request.age,
                    request.gender
                ),
                role = Role.USER
            )
        )
    }
}