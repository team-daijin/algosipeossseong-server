package site.algosipeosseong.domain.banner.application.dto

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.time.LocalDate

data class RegisterBannerRequest(
    @field:NotBlank(message = "필수 값입니다")
    val image: String,

    val redirectUrl: String,

    @field:NotNull(message = "필수 값입니다")
    @field:Past(message = "종료 날짜는 과거일 수 없습니다.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val endDate: LocalDate
)
