package site.algosipeosseong.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import site.algosipeosseong.global.config.property.AwsProperties
import site.algosipeosseong.global.config.property.JwtProperties


@ConfigurationPropertiesScan(
    basePackageClasses = [
        AwsProperties::class,
        JwtProperties::class
    ]
)

@Configuration
class PropertiesScanConfiguration
