package site.algosipeosseong.domain.expert.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import site.algosipeosseong.domain.expert.domain.Expert

@Repository
interface ExpertRepository : JpaRepository<Expert, Long> {
    fun findByUser_Id(userId: Long): Expert?
}