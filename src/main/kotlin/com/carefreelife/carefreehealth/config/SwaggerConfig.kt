package com.carefreelife.carefreehealth.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    val paths = arrayOf(
        "/api/v1/exercise/physical/**",
        "/api/v1/exercise/futsal/**"
    )
    var packageToScan = "com.carefreelife.carefreehealth"

    @Bean
    fun carefreeOpenAPI(): OpenAPI {
        val myContact = Contact()
            .name("채승민")
            .url("https://carefreelife98.github.com")
            .email("csm12180318@gmail.com")

        return OpenAPI()
            .info(
                Info().title("Carefree Health")
                    .version("1.0")
                    .contact(myContact)
                    .description("Carefree health 서비스의 API 명세입니다.")
            )
    }

    @Bean
    fun physicalTrainAPIs(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Carefree 헬스 트레이닝 API 그룹")
            .pathsToMatch(paths[0])
            .packagesToScan(packageToScan)
            .build()
    }

    @Bean
    fun futsalAPIs(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Carefree 풋살 API 그룹")
            .pathsToMatch(paths[1])
            .packagesToScan(packageToScan)
            .build()
    }

}