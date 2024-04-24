package site.algosipeosseong.domain.token.exception

import site.algosipeosseong.global.exception.AlgosipeosseongException

object InvalidTokenException : AlgosipeosseongException(
    TokenErrorCode.INVALID_TOKEN
)