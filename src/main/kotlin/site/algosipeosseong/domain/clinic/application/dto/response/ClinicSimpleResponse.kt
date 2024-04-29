package site.algosipeosseong.domain.clinic.application.dto.response

data class ClinicSimpleResponse(
    val id: Long,
    val image: String,
    val name: String,
    val address: String,
    val contact: String,
    val description: String
)