package site.algosipeosseong.domain.clinic.application.dto.request

import jakarta.validation.constraints.NotBlank

data class RegisterClinicRequest(
    @field:NotBlank(message = "필수 값입니다")
    val name: String,
    val image: String,
    @field:NotBlank(message = "필수 값입니다")
    val address: String,
    @field:NotBlank(message = "필수 값입니다")
    val introduce: String,
    @field:NotBlank(message = "필수 값입니다")
    val contact: String,
    @field:NotBlank(message = "필수 값입니다")
    val detailAddress: String,
    @field:NotBlank(message = "필수 값입니다")
    val streetAddress: String,
    val zipCode: Int,
    val latitude: Double,
    val longitude: Double
)
