package site.algosipeosseong.domain.user.domain.value

import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import site.algosipeosseong.domain.user.domain.constant.Gender
import java.io.Serializable

@Embeddable
data class Privacy(
    val name: String,

    val age: String,

    @Enumerated(EnumType.STRING)
    val gender: Gender
) : Serializable