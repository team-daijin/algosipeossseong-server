package site.algosipeosseong.domain.card.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.card.application.dto.response.CardResponse
import site.algosipeosseong.domain.card.infrastructure.CardRepository

@Component
class QueryCardUseCase(
    private val cardRepository: CardRepository
) {
    fun execute(id: Long): CardResponse {
        val card = cardRepository.findWithExpertById(id) ?: throw RuntimeException()
        return CardResponse(
            category = card.category.value,
            thumbnail = card.thumbnail,
            title = card.title,
            expert =  card.expert!!.name,
            content = card.content
        )
    }
}