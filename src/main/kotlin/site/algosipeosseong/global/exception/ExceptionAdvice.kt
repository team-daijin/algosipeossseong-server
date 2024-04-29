package site.algosipeosseong.global.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import site.algosipeosseong.global.exception.error.ErrorResponse

@RestControllerAdvice
class ExceptionAdvice {
    @ExceptionHandler(AlgosipeosseongException::class)
    fun businessException(e: AlgosipeosseongException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(e.errorProperty.status())
            .body(ErrorResponse.of(e.errorProperty))
    }
}