package site.algosipeosseong.domain.card.infrastructure

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import site.algosipeosseong.domain.card.domain.Card
import site.algosipeosseong.domain.card.domain.constant.Category

interface CardRepository : JpaRepository<Card, Long> {
    fun findTop5ByCategoryOrderByCreatedDateDesc(category: Category): List<Card>

    fun findByCategoryOrderByCreatedDateDesc(category: Category): List<Card>

    @EntityGraph(attributePaths = ["expert"])
    fun findWithExpertById(id: Long): Card?
}