package site.algosipeosseong.domain.banner.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.banner.application.dto.RegisterBannerRequest
import site.algosipeosseong.domain.banner.domain.Banner
import site.algosipeosseong.domain.banner.infrastructure.BannerRepository

@Component
class RegisterBannerUseCase(
    val bannerRepository: BannerRepository
) {
    fun execute(
        request: RegisterBannerRequest
    ) {
        bannerRepository.save(
            Banner(
                image = request.image,
                redirectUrl = request.redirectUrl,
                endDate = request.endDate
            )
        )
    }
}