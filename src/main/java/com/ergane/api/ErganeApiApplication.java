package com.ergane.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ErganeApiApplication {

	public static void main(String[] args) {
		// Esta linha é o motor que liga toda a API
		SpringApplication.run(ErganeApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner testarInicializacao(Environment env) {
		return args -> {
			System.out.println("\n=======================================================");
			System.out.println("🚀 API do Ergane inicializada com sucesso!");

			// Verifica qual profile está rodando (esperamos que seja o 'local')
			String profileAtivo = env.getProperty("spring.profiles.active");
			System.out.println("🔧 Perfil ativo no momento: " + profileAtivo);

			System.out.println("🗄️ O Spring Boot já leu o application.properties e");
			System.out.println("   estabeleceu a conexão com o MongoDB Atlas em background.");
			System.out.println("=======================================================\n");
		};
	}

}