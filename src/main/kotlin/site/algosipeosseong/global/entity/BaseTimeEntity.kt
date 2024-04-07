package site.algosipeosseong.global.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity(
    @CreatedDate
    @Column(updatable = false)
    protected val createdDate: LocalDateTime? = null,

    @LastModifiedDate
    protected val updateDate: LocalDateTime? = null
) {

}