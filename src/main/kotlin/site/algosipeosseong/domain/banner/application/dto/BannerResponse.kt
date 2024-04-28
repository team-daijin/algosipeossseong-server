package site.algosipeosseong.domain.banner.application.dto

data class BannerResponse(
    val id: Long,

    val image: String,

    val redirectUrl: String
)