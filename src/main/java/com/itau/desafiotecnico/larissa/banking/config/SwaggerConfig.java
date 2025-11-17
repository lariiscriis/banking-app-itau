package com.itau.desafiotecnico.larissa.banking.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bankinAppItau() {
        return new OpenAPI()
                .info(new Info()
                        .title("Banking Application Itau")
                        .description("Simple Banking Application Itau")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Larissa Cristina Bento Santana")
                                .email("larissa.santana.ae2020@gmail.com")
                                .url("https://github.com/lariiscriis"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}
