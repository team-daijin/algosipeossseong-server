package site.algosipeosseong.global.exception

import site.algosipeosseong.global.exception.error.ErrorProperty

abstract class AlgosipeosseongException(
    val errorProperty: ErrorProperty
): RuntimeException()