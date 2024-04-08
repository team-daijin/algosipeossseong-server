package site.algosipeosseong.domain.card.domain

import jakarta.persistence.*
import site.algosipeosseong.domain.expert.domain.Expert
import site.algosipeosseong.domain.user.domain.User
import site.algosipeosseong.global.entity.BaseTimeEntity

@Entity
data class Card(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val thumbnail: String,

    val title: String,

    val content: String,

    val category: String,

    @ElementCollection(fetch = FetchType.LAZY)
    val images: List<String>,

    @ManyToOne
    @JoinColumn(name = "expert_id")
    val expert: Expert
) : BaseTimeEntity()