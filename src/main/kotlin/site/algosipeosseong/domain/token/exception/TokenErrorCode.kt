package site.algosipeosseong.domain.token.exception

import org.springframework.http.HttpStatus
import site.algosipeosseong.global.exception.error.ErrorProperty

enum class TokenErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 만료 되었습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    ;

    override fun status(): HttpStatus = status
    override fun message(): String = message
}