package site.algosipeosseong.domain.banner.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import site.algosipeosseong.domain.banner.domain.Banner
import java.time.LocalDate

interface BannerRepository: JpaRepository<Banner, Long> {
    @Query(
        """
            select banner
            from Banner as banner
            where :now between :now and banner.endDate
        """
    )
    fun findAllByEndDateBefore(
        now: LocalDate
    ): List<Banner>
}