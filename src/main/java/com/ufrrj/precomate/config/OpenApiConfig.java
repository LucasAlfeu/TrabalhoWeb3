package com.ufrrj.precomate.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Preço de Tomate")
                .version("1.0.0")
                .description("Serviço REST para cálculo de preço de tomates com desconto por quantidade")
                .contact(new Contact()
                    .name("UFRRJ - Sistemas Web 3")
                    .email("contato@ufrrj.br")));
    }
}
