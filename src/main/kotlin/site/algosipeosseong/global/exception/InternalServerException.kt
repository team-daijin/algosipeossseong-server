package site.algosipeosseong.global.exception

import site.algosipeosseong.global.exception.error.GlobalErrorCode

object InternalServerException: AlgosipeosseongException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)