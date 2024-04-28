package site.algosipeosseong.global.security.auth

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import site.algosipeosseong.domain.user.infrastructure.UserRepository

@Service
class AuthUserService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return AuthUser(userRepository.findByIdOrNull(username.toLong()) ?: throw RuntimeException())
    }
}