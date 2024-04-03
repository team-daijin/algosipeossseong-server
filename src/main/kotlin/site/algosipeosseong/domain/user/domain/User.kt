package site.algosipeosseong.domain.user.domain

import jakarta.persistence.*
import site.algosipeosseong.domain.user.domain.constant.Role
import site.algosipeosseong.domain.user.domain.value.Password
import site.algosipeosseong.domain.user.domain.value.Privacy

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val accountId: String,

    val email: String,

    @Embedded
    var password: Password,

    @Embedded
    var privacy: Privacy? = null,

    @Enumerated(EnumType.STRING)
    val role: Role
) {
    fun updatePassword(password: Password) {
        this.password = password
    }

    fun updatePrivacy(privacy: Privacy) {
        this.privacy = privacy
    }
}
