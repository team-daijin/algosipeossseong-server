package site.algosipeosseong.domain.card.application.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import site.algosipeosseong.domain.card.domain.constant.Category

data class CreateCardRequest(
    val thumbnail: String,
    @field:NotBlank(message = "필수 값입니다")
    val title: String,
    @field:NotBlank(message = "필수 값입니니다.")
    val subTitle: String,
    @field:NotBlank(message = "필수 값입니다")
    val content: String,
    @field:NotNull(message = "필수 값입니다.")
    val category: Category,
)
