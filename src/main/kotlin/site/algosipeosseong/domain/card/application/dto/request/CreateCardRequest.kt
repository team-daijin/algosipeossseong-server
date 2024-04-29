package site.algosipeosseong.domain.card.application.dto.request

import site.algosipeosseong.domain.card.domain.constant.Category

data class CreateCardRequest(
    val thumbnail: String,
    val title: String,
    val content: String,
    val category: Category,
)
