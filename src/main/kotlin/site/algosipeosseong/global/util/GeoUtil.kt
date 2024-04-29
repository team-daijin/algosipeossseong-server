package site.algosipeosseong.global.util

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point

class GeoUtil {
    companion object {
        private val geometryFactory = GeometryFactory()
        private const val DEFAULT_SRID = 4326

        fun createPoint(latitude: Double, longitude: Double): Point {
            val point = geometryFactory.createPoint(Coordinate(longitude, latitude))
            point.srid = DEFAULT_SRID
            return point
        }
    }
}