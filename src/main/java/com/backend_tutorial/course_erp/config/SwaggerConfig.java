package com.backend_tutorial.course_erp.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Authorization",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact=new Contact()
                .name("Eyyub")
                .email("eyyubemirov9a@gmail.com");



        Info info = new Info()
                .version("1.0")
                .title("CourseStatus ERP API")
                .description("Bu API Spring Boot üçün Swagger konfiqurasiya nümunəsidir.")
                .contact(contact);
    return new  OpenAPI().info( info)
            .addSecurityItem(new SecurityRequirement().addList("Authorization")
            );
    }
}
