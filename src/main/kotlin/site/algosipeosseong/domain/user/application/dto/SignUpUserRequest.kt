package site.algosipeosseong.domain.user.application.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import site.algosipeosseong.domain.user.domain.constant.Gender

data class SignUpUserRequest(
    @field:NotBlank(message = "필수 값입니다")
    @field:Size(max = 20, message = "최대 20글자 입니다.")
    val accountId: String,

    @field:NotBlank(message = "필수 값입니다")
    @field:Email(message = "이메일 형식 이여야 합니다.")
    val email: String,

    @field:NotBlank(message = "필수 값입니다.")
    val password: String,

    @field:NotBlank(message = "필수 값입니다.")
    @field:Size(min = 3, message = "이름은 최소 3 글자 이상이어야 합니다.")
    val name: String,

    @field:NotBlank(message = "필수 값입니다.")
    @field:Size(min = 0, message = "나이는 최대 0 이상이어야 합니다.")
    val age: String,

    @field:NotNull(message = "필수 값입니다.")
    val gender: Gender
)
