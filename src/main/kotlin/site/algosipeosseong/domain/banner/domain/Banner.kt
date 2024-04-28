package site.algosipeosseong.domain.banner.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import site.algosipeosseong.global.entity.BaseTimeEntity
import java.time.LocalDate

@Entity
class Banner(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val image: String,

    val redirectUrl: String,

    val endDate: LocalDate
): BaseTimeEntity() {
}