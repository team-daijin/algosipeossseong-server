package site.algosipeosseong.global.exception.error

import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    private val status: HttpStatus,
    private val message: String
): ErrorProperty {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류")
    ;

    override fun status(): HttpStatus = status

    override fun message(): String = message
}