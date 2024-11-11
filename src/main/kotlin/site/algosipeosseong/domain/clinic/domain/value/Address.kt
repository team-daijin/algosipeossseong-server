package site.algosipeosseong.domain.clinic.domain.value

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class Address(
    val detailAddress: String,
    val streetAddress: String,
    val zipCode: Int
) : Serializable {

    fun getAddressDetails(): String {
        return "$streetAddress$detailAddress($zipCode)"
    }
    companion object {
        fun of(
            detailAddress: String,
            streetAddress: String,
            zipCode: Int
        ): Address {
            return Address(
                detailAddress = detailAddress,
                streetAddress = streetAddress,
                zipCode = zipCode
            )
        }
    }
}