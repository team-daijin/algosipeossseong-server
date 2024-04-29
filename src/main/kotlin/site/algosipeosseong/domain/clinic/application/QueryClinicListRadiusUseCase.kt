package site.algosipeosseong.domain.clinic.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.clinic.application.dto.request.ClinicListRadiusRequest
import site.algosipeosseong.domain.clinic.application.dto.response.ClinicSimpleResponse
import site.algosipeosseong.domain.clinic.domain.Clinic
import site.algosipeosseong.domain.clinic.infrastructure.ClinicRepository
import site.algosipeosseong.global.util.GeoUtil

@Component
class QueryClinicListRadiusUseCase(
    private val clinicRepository: ClinicRepository
) {
    fun execute(
        request: ClinicListRadiusRequest,
        distance: Int
    ): List<ClinicSimpleResponse> {
        val point = GeoUtil.createPoint(request.latitude, request.longitude)
        val clinics = clinicRepository.findAllWithInCircleArea(point, distance)
        return clinics.stream().map {
            ClinicSimpleResponse(
                id = it.id!!,
                image = it.image,
                name = it.name,
                address = it.address,
                contact = it.contact,
                description = it.description
            )
        }.toList()
    }
}