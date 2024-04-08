package site.algosipeosseong.global.config

import org.springframework.context.annotation.Configuration
import site.algosipeosseong.global.config.property.AwsProperties

@Configuration
class S3Configuration(
    private val awsProperties: AwsProperties
) {
}