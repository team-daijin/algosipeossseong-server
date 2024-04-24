package site.algosipeosseong.global.exception.error

data class ErrorResponse(
    val status: Int,
    val message: String
) {
    companion object {
        fun of(errorProperty: ErrorProperty): ErrorResponse {
            return ErrorResponse(status = errorProperty.status().value(), message = errorProperty.message())
        }
    }
}
