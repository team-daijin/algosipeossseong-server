package site.algosipeosseong.domain.clinic.domain

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Clinic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val image: String,

    val name: String,

    val address: String,

    val description: String,

    val contact: String,

    @Embedded
    val coordinate: Coordinate
)