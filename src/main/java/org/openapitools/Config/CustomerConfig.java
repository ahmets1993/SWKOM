package org.openapitools.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Swagger Software Components System - OpenAPI 3.0")
                                .description("This web service was written as a University project. The relevant course of the project is Software Components System. Technologies aimed to be learned throughout the project are as follows:\n" +
                                        "\n" +
                                        "1. Open API Generator : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n" +
                                        "\n" +
                                        "2. Spring Framework : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n" +
                                        "\n" +
                                        "3. Swagger UI : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n" +
                                        "\n" +
                                        "4. CI/CD - Github Actions : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n" +
                                        "\n" +
                                        "5. AWS : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n" +
                                        "\n" +
                                        "6. Docker : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n" +
                                        "\n\n" +
                                        "7. Postgres : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n" +

                                        "\n" +
                                        "Project developers: Ahmet Satilmis & Amal Mostafa")
                                .termsOfService("http://swagger.io/terms/")
                                .contact(
                                        new Contact()
                                                .email("apiteam@swagger.io")
                                )
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")
                                )
                                .version("1.0.15")
                )
                .components(
                        new Components()
                                .addSecuritySchemes("api_key", new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)
                                        .name("api_key")
                                )
                                .addSecuritySchemes("petstore_auth", new SecurityScheme()
                                        .type(SecurityScheme.Type.OAUTH2)
                                )
                )
                ;
    }
}