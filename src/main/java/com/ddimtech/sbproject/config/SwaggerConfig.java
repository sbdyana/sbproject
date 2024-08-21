package com.ddimtech.sbproject.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info().title("Sbproject Dept API 명세서").version("v1")
                .description("""
                        * GET, POST 만 사용합니다.
                """);

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}