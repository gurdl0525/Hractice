package com.example.global.config.property

import com.example.global.config.security.SecurityProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackageClasses = [SecurityProperties::class])
@Configuration
class ConfigurationPropertiesConfig