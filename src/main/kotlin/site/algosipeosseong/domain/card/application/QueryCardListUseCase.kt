package site.algosipeosseong.domain.card.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.card.application.dto.response.CardCategoryListResponse
import site.algosipeosseong.domain.card.application.dto.response.CardSimpleResponse
import site.algosipeosseong.domain.card.domain.constant.Category
import site.algosipeosseong.domain.card.infrastructure.CardRepository

@Component
class QueryCardListUseCase(
    private val cardRepository: CardRepository
) {
    fun execute(): List<CardCategoryListResponse> {
        val response: MutableList<CardCategoryListResponse> = mutableListOf()
        for (category in Category.entries) {
            val card = cardRepository.findTop5ByCategoryOrderByCreatedDateDesc(category)
            response.add(
                CardCategoryListResponse(
                    category = category.value,
                    cards = card.stream().map {
                        CardSimpleResponse(it.thumbnail, it.category.value, it.title)
                    }.toList()
                )
            )
        }

        return response
    }
}