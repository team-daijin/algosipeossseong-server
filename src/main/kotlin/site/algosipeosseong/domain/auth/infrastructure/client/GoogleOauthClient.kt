package site.algosipeosseong.domain.auth.infrastructure.client

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange
import site.algosipeosseong.domain.auth.application.dto.response.OAuthAccessTokenResponse
import site.algosipeosseong.domain.auth.infrastructure.client.dto.request.GoogleOauthAccessTokenRequest
import site.algosipeosseong.domain.auth.infrastructure.client.dto.response.GoogleUserInformationResponse

@HttpExchange()
interface GoogleOauthClient {
    @PostExchange("https://oauth2.googleapis.com/token")
    fun getAccessToken(
        @RequestBody request: GoogleOauthAccessTokenRequest
    ): OAuthAccessTokenResponse

    @GetExchange("https://www.googleapis.com/drive/v2/files?access_token=access_token")
    fun getUserInformation(
        @RequestParam(name = "access_token") accessToken: String
    ): GoogleUserInformationResponse
}