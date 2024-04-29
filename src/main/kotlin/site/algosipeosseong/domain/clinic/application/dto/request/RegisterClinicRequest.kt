package site.algosipeosseong.domain.clinic.application.dto.request

data class RegisterClinicRequest(
    val name: String,
    val image: String,
    val address: String,
    val introduce: String,
    val contact: String,
    val latitude: Double,
    val longitude: Double
)
