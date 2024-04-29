package site.algosipeosseong.domain.card.application.dto.response

data class CardResponse(
    val thumbnail: String,
    val category: String,
    val title: String,
    val expert: String,
    val content: String,
)