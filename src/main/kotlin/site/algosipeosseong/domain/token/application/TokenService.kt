package site.algosipeosseong.domain.token.application

interface TokenService {
    fun generateAccessToken(memberId: Long): String

    fun generateRefreshToken(memberId: Long): String

    fun getTokenFromHeader(header: String?): String?

    fun extractIdFromToken(token: String): String
}