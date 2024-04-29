package site.algosipeosseong.domain.auth.exception.error

import org.springframework.http.HttpStatus
import site.algosipeosseong.global.exception.error.ErrorProperty

enum class UserErrorCode(
    private val status: HttpStatus,
    private val message: String
): ErrorProperty {
    NOT_FOUND_EMAIL(HttpStatus.NOT_FOUND, "이메일을 찾지 못하였습니다."),
    MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.")
    ;

    override fun status(): HttpStatus = status

    override fun message(): String = message
}