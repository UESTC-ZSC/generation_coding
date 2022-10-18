package com.monsters.generationcodingadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GenerationCodingAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerationCodingAdminApplication.class, args);
	}

}
