package site.algosipeosseong.global.exception.error

import org.springframework.boot.context.properties.bind.BindResult
import org.springframework.validation.BindingResult

data class ErrorResponse(
    val status: Int,
    val message: Any
) {
    companion object {
        fun of(errorProperty: ErrorProperty): ErrorResponse {
            return ErrorResponse(status = errorProperty.status().value(), message = errorProperty.message())
        }

        fun of(e: BindingResult): ErrorResponse {
            val errorMap = HashMap<String, String?>()

            for (error in e.fieldErrors) {
                errorMap[error.field] = error.defaultMessage
            }

            return ErrorResponse(
                status = 400,
                message = errorMap
            )
        }


    }
}
