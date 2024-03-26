package site.algosipeosseong.domain.user.domain

import jakarta.persistence.*
import site.algosipeosseong.domain.user.domain.constant.Role
import site.algosipeosseong.domain.user.domain.value.Password
import site.algosipeosseong.domain.user.domain.value.Privacy

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val email: String,

    @Embedded
    val password: Password,

    @Embedded
    val privacy: Privacy,

    @Enumerated(EnumType.STRING)
    val role: Role
)
