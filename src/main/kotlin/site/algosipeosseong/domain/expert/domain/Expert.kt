package site.algosipeosseong.domain.expert.domain

import jakarta.persistence.*
import site.algosipeosseong.domain.user.domain.User

@Entity
data class Expert(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val job: String,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,
)