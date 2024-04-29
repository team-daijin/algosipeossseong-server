package site.algosipeosseong.domain.clinic.application.dto.request

import jakarta.validation.constraints.NotNull

data class ClinicListRadiusRequest(
    @field:NotNull(message = "필수 값입니다.")
    val latitude: Double,

    @field:NotNull(message = "필수 값입니다.")
    val longitude: Double
)