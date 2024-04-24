package site.algosipeosseong.global.exception

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import site.algosipeosseong.global.exception.error.ErrorResponse
import java.nio.charset.StandardCharsets

class ExceptionFilter(
    private val objectMapper: ObjectMapper
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e : AlgosipeosseongException) {
            setErrorResponse(e, response)
        } catch (e: Exception) {
            when(e.cause) {
                is AlgosipeosseongException -> {
                    e.printStackTrace()
                    setErrorResponse(e.cause as AlgosipeosseongException, response)
                } else -> {
                    setErrorResponse(InternalServerException, response)
                }
            }
        }
    }

    private fun setErrorResponse(exception: AlgosipeosseongException, response: HttpServletResponse) {
        response.status = exception.errorProperty.status().value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.writer.write(
            objectMapper.writeValueAsString(
                ErrorResponse.of(exception.errorProperty)
            )
        )
    }
}