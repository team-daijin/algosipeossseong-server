package site.algosipeosseong.domain.card.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.card.application.dto.response.CardSimpleResponse
import site.algosipeosseong.domain.card.domain.constant.Category
import site.algosipeosseong.domain.card.infrastructure.CardRepository

@Component
class QueryCardListByCategoryUseCase(
    private val cardRepository: CardRepository
) {
    fun execute(
        category: Category
    ): List<CardSimpleResponse> {
        val cards = cardRepository.findByCategoryOrderByCreatedDateDesc(category)

        return cards.stream().map {
            CardSimpleResponse(it.thumbnail, it.category.value, it.title)
        }.toList()
    }
}