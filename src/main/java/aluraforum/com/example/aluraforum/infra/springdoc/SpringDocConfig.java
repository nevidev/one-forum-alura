package aluraforum.com.example.aluraforum.infra.springdoc;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(
                        new Components()
                                .addSecuritySchemes("bearer-key",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("API Aluraforum")
                        .description("API Rest da aplicação de um forum alura, contendo as funcionalidades básicas de" +
                                " um fórum " +
                                "administração de usuários")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@aluraforum.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://aluraforum/api/licenca")));
    }

}
