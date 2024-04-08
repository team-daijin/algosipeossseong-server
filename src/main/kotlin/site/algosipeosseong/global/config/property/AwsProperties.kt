package site.algosipeosseong.global.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws")
class AwsProperties (
    val s3 : S3,
    val credentials : Credentials
) {
    inner class S3 (
        val bucket: String
    )

    inner class Credentials (
        val accessKey: String,
        val secretKey: String
    )
}