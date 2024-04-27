package site.algosipeosseong.domain.token.application

interface TokenService {
    fun generateAccessToken(id: Long): String

    fun generateRefreshToken(id: Long): String

    fun getTokenFromHeader(header: String?): String?

    fun extractIdFromToken(token: String): String
}