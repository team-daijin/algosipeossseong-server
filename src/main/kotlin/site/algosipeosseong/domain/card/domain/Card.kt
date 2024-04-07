package site.algosipeosseong.domain.card.domain

import jakarta.persistence.*
import site.algosipeosseong.domain.user.domain.User
import site.algosipeosseong.global.entity.BaseTimeEntity

@Entity
data class Card(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val thumbnail: String,

    val title: String,

    val content: String,

    val category: String,

    @ElementCollection(fetch = FetchType.LAZY)
    val images: List<String>,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
) : BaseTimeEntity()