package site.algosipeosseong.global.exception.error

import org.springframework.http.HttpStatus

interface ErrorProperty {
    fun status(): HttpStatus
    fun message(): String
}