package site.algosipeosseong.domain.auth.exception

import site.algosipeosseong.domain.auth.exception.error.UserErrorCode
import site.algosipeosseong.global.exception.AlgosipeosseongException

object NotFoundUserEmailException : AlgosipeosseongException(
    UserErrorCode.NOT_FOUND_EMAIL
) {
}