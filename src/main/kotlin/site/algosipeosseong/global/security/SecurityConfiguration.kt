package site.algosipeosseong.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import site.algosipeosseong.domain.token.application.TokenService
import site.algosipeosseong.domain.user.domain.constant.Role
import site.algosipeosseong.global.exception.ExceptionFilter
import site.algosipeosseong.global.security.auth.AuthUserService

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val objectMapper: ObjectMapper,
    private val tokenService: TokenService,
    private val authUserService: AuthUserService
) {

    @Bean
    protected fun security(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .cors { corsConfigurationSource() }
            .formLogin { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        http.authorizeHttpRequests {
            it
                .requestMatchers(HttpMethod.POST, "/card").hasRole(Role.EXPERT.name)
                .requestMatchers(HttpMethod.POST, "/file/upload").hasRole(Role.EXPERT.name)
                .requestMatchers(HttpMethod.POST, "/banner").hasRole(Role.EXPERT.name)
                .requestMatchers(HttpMethod.POST, "/clinic/register").hasRole(Role.EXPERT.name)
                .anyRequest().permitAll()
        }


        http.addFilterBefore(
            JwtAuthenticationFilter(
                tokenService, authUserService
            ),
            UsernamePasswordAuthenticationFilter::class.java
        )

        http.addFilterBefore(
            ExceptionFilter(
                objectMapper
            ),
            JwtAuthenticationFilter::class.java
        )
        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration().also {
            it.allowedOrigins = listOf("*")
            it.allowedMethods = listOf(HttpMethod.POST.name(), HttpMethod.GET.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name())
            it.allowedHeaders = listOf(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION)
        }
        return UrlBasedCorsConfigurationSource().also {
            it.registerCorsConfiguration("/**", configuration)
        }
    }
}