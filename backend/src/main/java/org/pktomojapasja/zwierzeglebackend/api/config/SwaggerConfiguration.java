package org.pktomojapasja.zwierzeglebackend.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SwaggerConfiguration.SwaggerProperties.class)
@RequiredArgsConstructor
public class SwaggerConfiguration {
    private final SwaggerProperties swaggerProperties;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info().title(swaggerProperties.getTitle())
                        .description(swaggerProperties.getDescription()));
    }

    @ConfigurationProperties("springdoc.info")
    @Getter
    @Setter
    static class SwaggerProperties {
        private String title;
        private String description;
    }
}