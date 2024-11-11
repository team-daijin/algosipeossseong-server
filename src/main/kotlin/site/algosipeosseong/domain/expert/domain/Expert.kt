package site.algosipeosseong.domain.expert.domain

import jakarta.persistence.*
import site.algosipeosseong.domain.user.domain.User

@Entity
class Expert(
    id: Long,
    name: String,
    job: String,
    user: User
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        protected set

    var name: String = name
        protected set

    var job: String = job
        protected set

    @OneToOne
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set
}