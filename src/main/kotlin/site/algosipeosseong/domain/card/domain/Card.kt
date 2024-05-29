package site.algosipeosseong.domain.card.domain

import jakarta.persistence.*
import site.algosipeosseong.domain.card.domain.constant.Category
import site.algosipeosseong.domain.expert.domain.Expert
import site.algosipeosseong.global.entity.BaseTimeEntity
import java.time.LocalDateTime

@Entity
data class Card(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val thumbnail: String,

    val title: String,

    val subTitle: String,

    val content: String,

    @Enumerated(value = EnumType.STRING)
    val category: Category,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_id")
    val expert: Expert,
) : BaseTimeEntity() {
}