package br.com.well.testeActiveMq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class TesteActiveMqApplication {

	private static final Logger log = LoggerFactory.getLogger(TesteActiveMqApplication.class);

	public static void main(String[] args) {
		log.info("Iniciando a aplicação!");
		SpringApplication.run(TesteActiveMqApplication.class, args);
		log.info("Iniciado com sucesso!");
	}
}
