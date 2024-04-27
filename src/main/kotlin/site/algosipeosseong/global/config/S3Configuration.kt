package site.algosipeosseong.global.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import site.algosipeosseong.global.config.property.AwsProperties

@Configuration
class S3Configuration(
    private val awsProperties: AwsProperties
) {
    @Value("\${cloud.aws.region.static}")
    private val region: String? = null

    @Bean
    fun amazonS3C(): AmazonS3 {
        return AmazonS3ClientBuilder.standard()
            .withRegion(region)
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(
                        awsProperties.credentials.accessKey,
                        awsProperties.credentials.secretKey
                )
            )).build()
    }
}