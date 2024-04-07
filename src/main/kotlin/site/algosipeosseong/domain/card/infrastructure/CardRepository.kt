package site.algosipeosseong.domain.card.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import site.algosipeosseong.domain.card.domain.Card

interface CardRepository : JpaRepository<Card, Long> {
}