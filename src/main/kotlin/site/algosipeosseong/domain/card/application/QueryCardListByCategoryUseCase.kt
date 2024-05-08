package site.algosipeosseong.domain.card.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.card.application.dto.response.CardSimpleResponse
import site.algosipeosseong.domain.card.domain.constant.Category
import site.algosipeosseong.domain.card.infrastructure.CardRepository
import site.algosipeosseong.global.util.DateUtil

@Component
class QueryCardListByCategoryUseCase(
    private val cardRepository: CardRepository
) {
    fun execute(
        category: Category
    ): List<CardSimpleResponse> {
        val cards = cardRepository.findByCategoryOrderByCreatedDateDesc(category)


        return cards.stream().map {
            CardSimpleResponse(
                id = it.id!!,
                thumbnail = it.thumbnail,
                category = it.category.value,
                expert = it.expert.name,
                date = DateUtil.dateToString(it.createdDate!!),
                title = it.title,
                subTitle = it.subTitle
                )
        }.toList()
    }
}