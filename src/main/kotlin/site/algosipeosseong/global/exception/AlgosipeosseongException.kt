package site.algosipeosseong.global.exception

import site.algosipeosseong.global.exception.error.ErrorProperty

abstract class AlgosipeosseongException(
    private val errorProperty: ErrorProperty
): RuntimeException()