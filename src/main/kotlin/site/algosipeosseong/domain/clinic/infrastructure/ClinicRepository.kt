package site.algosipeosseong.domain.clinic.infrastructure

import org.locationtech.jts.geom.Point
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import site.algosipeosseong.domain.clinic.domain.Clinic

@Repository
interface ClinicRepository : JpaRepository<Clinic, Long> {
    fun existsByName(name: String): Boolean

    @Query(
        """  
        SELECT co
        FROM Clinic AS co  
        WHERE st_contains(st_buffer(:center, :radius), co.coordinate.point)
        """
    )
    fun findAllWithInCircleArea(
        @Param("center") point: Point,
        @Param("radius") radius: Int
    ): List<Clinic>
}