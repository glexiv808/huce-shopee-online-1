package com.huce.shopee_online;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "My API",
                version = "1.0",
                description = "API documentation for my application",
                contact = @Contact(
                        name = "Your Name",
                        url = "http://yourwebsite.com",
                        email = "your.email@example.com"
                )
        )
)
public class OpenApiConfig {

//    @Bean
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("public-api")
//                .pathsToMatch("/api/**") // Adjust this to your API path
//                .build();
//    }
}

