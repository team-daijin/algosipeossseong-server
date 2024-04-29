package site.algosipeosseong.domain.card.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import site.algosipeosseong.domain.card.application.CreateCardUseCase
import site.algosipeosseong.domain.card.application.QueryCardListByCategoryUseCase
import site.algosipeosseong.domain.card.application.QueryCardListUseCase
import site.algosipeosseong.domain.card.application.QueryCardUseCase
import site.algosipeosseong.domain.card.application.dto.response.CardCategoryListResponse
import site.algosipeosseong.domain.card.application.dto.response.CardResponse
import site.algosipeosseong.domain.card.application.dto.request.CreateCardRequest
import site.algosipeosseong.domain.card.application.dto.response.CardSimpleResponse
import site.algosipeosseong.domain.card.domain.constant.Category
import site.algosipeosseong.global.annotation.AuthenticatedPrincipalId

@RestController
@RequestMapping("/card")
class CardController(
    private val createCardUseCase: CreateCardUseCase,
    private val queryCardListUseCase: QueryCardListUseCase,
    private val queryCardListByCategoryUseCase: QueryCardListByCategoryUseCase,
    private val queryCardUseCase: QueryCardUseCase
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCard(
        @RequestBody request: CreateCardRequest,
        @AuthenticatedPrincipalId userId: Long
    ) {
        return createCardUseCase.execute(request, userId)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getCardList(): List<CardCategoryListResponse> {
        return queryCardListUseCase.execute()
    }

    @GetMapping("/{category}")
    fun getCardListByCategory(
        @PathVariable(name = "category") category: Category
    ): List<CardSimpleResponse> {
        return queryCardListByCategoryUseCase.execute(category)
    }

    @GetMapping("/{cardId}")
    @ResponseStatus(HttpStatus.OK)
    fun getCardById(
        @PathVariable(name = "cardId") id: Long
    ): CardResponse {
        return queryCardUseCase.execute(id)
    }
}