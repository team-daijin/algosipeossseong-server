package site.algosipeosseong.domain.user.domain.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class Password (
    @Column(name = "password")
    val value: String
) : Serializable {
    companion object {
        fun of(value: String): Password {
            return Password(value)
        }
    }

}
