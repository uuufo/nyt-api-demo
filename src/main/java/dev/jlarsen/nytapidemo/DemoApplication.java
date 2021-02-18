package dev.jlarsen.nytapidemo;

import dev.jlarsen.nytapidemo.models.Role;
import dev.jlarsen.nytapidemo.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInitialRoleData(RoleRepository roleRepository) {
		return (args) -> {
			if (((Collection<Role>)roleRepository.findAll()).size() == 0) {
				roleRepository.save(new Role("ADMIN"));
				roleRepository.save(new Role("USER"));
			}
		};
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
