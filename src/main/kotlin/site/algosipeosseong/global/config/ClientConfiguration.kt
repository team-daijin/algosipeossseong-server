package site.algosipeosseong.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import site.algosipeosseong.domain.auth.infrastructure.client.GoogleOauthClient

@Configuration
class ClientConfiguration(
    private val restClient: RestClient
) {
    @Bean
    fun googleOauthClient(): GoogleOauthClient {
        val factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
        return factory.build().createClient(GoogleOauthClient::class.java)
    }
}