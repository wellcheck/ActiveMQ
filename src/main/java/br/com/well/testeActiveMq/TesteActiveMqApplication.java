package br.com.well.testeActiveMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class TesteActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteActiveMqApplication.class, args);
	}
}
