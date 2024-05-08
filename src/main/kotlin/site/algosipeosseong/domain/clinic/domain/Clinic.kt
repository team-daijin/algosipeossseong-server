package site.algosipeosseong.domain.clinic.domain

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import site.algosipeosseong.domain.clinic.domain.value.Address
import site.algosipeosseong.domain.clinic.domain.value.Coordinate

@Entity
data class Clinic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val image: String,

    val name: String,

    val description: String,

    val contact: String,

    @Embedded
    val address: Address,

    @Embedded
    val coordinate: Coordinate
)