package site.algosipeosseong.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import site.algosipeosseong.global.config.property.AwsProperties


@ConfigurationPropertiesScan(
    basePackageClasses = [
        AwsProperties::class
    ]
)

@Configuration
class PropertiesScanConfiguration