package site.algosipeosseong.domain.token.domain

import jakarta.persistence.Index
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(
    @Id
    val id: String? = null,
    @Indexed
    val token: String,
    @TimeToLive
    val ttl: Long
) {

}