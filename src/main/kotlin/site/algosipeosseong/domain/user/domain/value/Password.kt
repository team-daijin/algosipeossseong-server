package site.algosipeosseong.domain.user.domain.value

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class Password (
    val value: String
) : Serializable {
    companion object {
        fun of(value: String): Password {
            return Password(value)
        }
    }

}
