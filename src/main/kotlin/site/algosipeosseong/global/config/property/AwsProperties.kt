package site.algosipeosseong.global.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws")
class AwsProperties (
    val s3 : S3,
    val credentials : Credentials
) {
    class S3 (
        val bucket: String
    )

    class Credentials (
        val accessKey: String,
        val secretKey: String
    )
}
