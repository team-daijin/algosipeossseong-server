package site.algosipeosseong.domain.card.application.dto.response

data class CardCategoryListResponse(
    val category: String,
    val cards: List<CardSimpleResponse>
)