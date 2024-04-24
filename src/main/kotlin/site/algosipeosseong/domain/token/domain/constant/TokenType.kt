package site.algosipeosseong.domain.token.domain.constant

enum class TokenType(
    val value: String
) {
    ACCESS_TOKEN("access_token"),
    REFRESH_TOKEN("refresh_token")
}