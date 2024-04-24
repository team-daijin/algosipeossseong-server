package site.algosipeosseong.domain.token.exception

import site.algosipeosseong.global.exception.AlgosipeosseongException

object ExpiredTokenException : AlgosipeosseongException(
    TokenErrorCode.EXPIRED_TOKEN
)