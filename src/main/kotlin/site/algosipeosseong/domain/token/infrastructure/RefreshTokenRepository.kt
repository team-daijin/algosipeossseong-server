package site.algosipeosseong.domain.token.infrastructure

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import site.algosipeosseong.domain.token.domain.RefreshToken

@Repository
interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
}