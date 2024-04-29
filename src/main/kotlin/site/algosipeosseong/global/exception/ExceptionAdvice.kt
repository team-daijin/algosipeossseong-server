package site.algosipeosseong.global.exception

import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import site.algosipeosseong.global.exception.error.ErrorResponse

@RestControllerAdvice
class ExceptionAdvice {
    @ExceptionHandler(AlgosipeosseongException::class)
    fun businessException(
        e: AlgosipeosseongException
    ) = ErrorResponse.of(e.errorProperty)

    @ExceptionHandler(BindException::class)
    fun bindException(
        e: BindException
    ) = ErrorResponse.of(e.bindingResult)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(
        e: MethodArgumentNotValidException
    ) = ErrorResponse.of(e)


}