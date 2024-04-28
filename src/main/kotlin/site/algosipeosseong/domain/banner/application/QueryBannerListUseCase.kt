package site.algosipeosseong.domain.banner.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.banner.application.dto.BannerResponse
import site.algosipeosseong.domain.banner.infrastructure.BannerRepository
import java.time.LocalDate

@Component
class QueryBannerListUseCase(
    private val bannerRepository: BannerRepository
) {
    fun execute(): List<BannerResponse> {
        val banners = bannerRepository.findAllByEndDateBefore(LocalDate.now())

        return banners.stream().map {
            BannerResponse(
                id = it.id!!,
                image = it.image,
                redirectUrl = it.redirectUrl
            )
        }.toList()
    }
}