package site.algosipeosseong.domain.banner.application.dto

import java.time.LocalDate

data class RegisterBannerRequest(
    val image: String,
    val redirectUrl: String,
    val endDate: LocalDate
)
