package site.algosipeosseong.global.util

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object PasswordUtil {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun encoded(raw: String): String {
        return passwordEncoder.encode(raw)
    }
}