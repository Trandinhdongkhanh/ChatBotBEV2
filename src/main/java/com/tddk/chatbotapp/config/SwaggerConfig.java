package com.tddk.chatbotapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Chat bot API",
                version = "1.0",
                contact = @Contact(
                        name = "TDDK", email = "tddk@tma.com.vn", url = "https://www.baeldung.com"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                termsOfService = "https://www.apache.org/licenses/LICENSE-2.0",
                description = "This is API made by TDDK"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local"
                ),
                @Server(
                        url = "https://your-url",
                        description = "Production"
                )
        },
        security = {
                @SecurityRequirement(name = "Bearer Auth")
        }
)
@SecurityScheme(
        name = "Bearer Auth",
        description = "JWT Auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {

}
