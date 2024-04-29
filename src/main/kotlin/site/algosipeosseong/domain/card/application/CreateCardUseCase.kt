package site.algosipeosseong.domain.card.application

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import site.algosipeosseong.domain.card.application.dto.request.CreateCardRequest
import site.algosipeosseong.domain.card.domain.Card
import site.algosipeosseong.domain.card.infrastructure.CardRepository
import site.algosipeosseong.domain.expert.infrastructure.ExpertRepository

@Component
class CreateCardUseCase(
    private val cardRepository: CardRepository,
    private val expertRepository: ExpertRepository
) {
    @Transactional
    fun execute(
        request: CreateCardRequest,
        userId: Long
    ) {
        val expert = expertRepository.findByUser_Id(userId) ?: throw RuntimeException()

        cardRepository.save(
            Card(
                thumbnail = request.thumbnail,
                title = request.title,
                content = request.content,
                category = request.category,
                expert = expert
            )
        )
    }

}