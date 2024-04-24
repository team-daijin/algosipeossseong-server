package site.algosipeosseong.global.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import site.algosipeosseong.domain.token.application.TokenService
import site.algosipeosseong.global.security.auth.AuthUserService

@Component
class JwtAuthenticationFilter(
    private val tokenService: TokenService,
    private val authUserService: AuthUserService
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val bearerToken = tokenService.getTokenFromHeader(request.getHeader(HttpHeaders.AUTHORIZATION))

        if (bearerToken != null) {
            val id = tokenService.extractIdFromToken(bearerToken)
            val authUser = authUserService.loadUserByUsername(id)
            val authentication = UsernamePasswordAuthenticationToken(
                authUser, null, authUser.authorities
            )
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }
}