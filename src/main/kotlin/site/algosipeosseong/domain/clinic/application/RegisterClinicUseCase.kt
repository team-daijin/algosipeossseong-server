package site.algosipeosseong.domain.clinic.application

import org.springframework.stereotype.Component
import site.algosipeosseong.domain.clinic.application.dto.request.RegisterClinicRequest
import site.algosipeosseong.domain.clinic.domain.Clinic
import site.algosipeosseong.domain.clinic.domain.Coordinate
import site.algosipeosseong.domain.clinic.infrastructure.ClinicRepository
import site.algosipeosseong.global.util.GeoUtil

@Component
class RegisterClinicUseCase(
    private val clinicRepository: ClinicRepository,
) {
    fun execute(
        request: RegisterClinicRequest
    ) {
        if (clinicRepository.existsByName(request.name)) throw RuntimeException()

        clinicRepository.save(Clinic(
            name = request.name,
            image = request.image,
            address = request.address,
            description = request.introduce,
            contact = request.contact,
            coordinate = Coordinate(point = GeoUtil.createPoint(request.latitude, request.longitude))
        ))
    }
}