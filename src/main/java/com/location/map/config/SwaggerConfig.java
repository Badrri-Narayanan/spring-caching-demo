package com.location.map.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("badrri1995@gmail.com");
        contact.setName("Badrri Narayanan");
        contact.setUrl("https://badrri-narayanan.github.io");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
            .title("Title of API")
            .version("1.0")
            .contact(contact)
            .description("This API is a starter kit for Swagger UI").termsOfService("https://www.sample.com/terms")
            .license(mitLicense);

        return new OpenAPI().info(info);
    }
}