package com.cursocodemin.codemin;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
public class CodeminApplication {
	private static Logger logger = LoggerFactory.getLogger(CodeminApplication.class);

	@GetMapping("/")
	public String Index(){
		return "Hello World";
	}

	public static void loadEnv(){
		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
	}
	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(CodeminApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		String[] allowedMethods = { "GET", "POST", "PUT", "DELETE", "OPTIONS" };
		String[] allowedHeaders = { "Authorization", "Content-Type" };
		String[] allowDomains = { "http://localhost:4200" };

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins(allowDomains)
						.allowedMethods(allowedMethods)
						.allowedHeaders(allowedHeaders)
						.allowCredentials(true);
			}

		};
	}


}
