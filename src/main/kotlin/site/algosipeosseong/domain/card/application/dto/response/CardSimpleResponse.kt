package site.algosipeosseong.domain.card.application.dto.response

data class CardSimpleResponse(
    val id: Long,
    val thumbnail: String,
    val category: String,
    val title: String
)