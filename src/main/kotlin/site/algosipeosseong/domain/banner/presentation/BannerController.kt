package site.algosipeosseong.domain.banner.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import site.algosipeosseong.domain.banner.application.QueryBannerListUseCase
import site.algosipeosseong.domain.banner.application.RegisterBannerUseCase
import site.algosipeosseong.domain.banner.application.dto.BannerResponse
import site.algosipeosseong.domain.banner.application.dto.RegisterBannerRequest

@RestController
@RequestMapping("/banner")
class BannerController(
    private val registerBannerUseCase: RegisterBannerUseCase,
    private val queryBannerListUseCase: QueryBannerListUseCase
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerBanner(
        @RequestBody request: RegisterBannerRequest
    ) {
        registerBannerUseCase.execute(request)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun getBannerList(
    ): List<BannerResponse> {
        return queryBannerListUseCase.execute()
    }

}