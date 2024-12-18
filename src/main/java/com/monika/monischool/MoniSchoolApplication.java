package com.monika.monischool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.monika.monischool.repository")
@EntityScan("com.monika.monischool.model")
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
public class MoniSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoniSchoolApplication.class, args);
	}

}
