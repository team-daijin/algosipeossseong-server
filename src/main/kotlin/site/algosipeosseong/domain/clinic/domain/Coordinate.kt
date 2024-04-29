package site.algosipeosseong.domain.clinic.domain

import jakarta.persistence.Embeddable
import org.locationtech.jts.geom.Point
import java.io.Serializable

@Embeddable
data class Coordinate(
    val point: Point
): Serializable {
    companion object {
        fun of(point: Point): Coordinate {
            return Coordinate(point = point)
        }
    }
}