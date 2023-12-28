package com.br.ebatista.springboot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ODV APIs", description = "E-commerce Library ODV APIs" +
        " Affiliate credentials: " +
        "{ \"login\": \"odv\"," +
        "\"password\": \"123\" }",
        version = "1.0"))
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
