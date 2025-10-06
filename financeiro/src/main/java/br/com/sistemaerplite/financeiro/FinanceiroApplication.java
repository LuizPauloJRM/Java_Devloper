package br.com.sistemaerplite.financeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * A anotação @SpringBootApplication é uma anotação de conveniência que combina
 * três anotações:
 * 1. @EnableAutoConfiguration: Habilita a configuração automática do Spring Boot.
 * 2. @ComponentScan: Faz o escaneamento do pacote atual e subpacotes em busca
 *    de componentes (como @Component, @Service, @Repository e, neste caso, @RestController).
 * 3. @Configuration: Indica que a classe pode conter definições de beans.
 *
 * A aplicação é iniciada a partir do método main(), que chama
 * SpringApplication.run(), responsável por inicializar o contexto da aplicação.
 */
@SpringBootApplication
/*@Profile("")*/
public class FinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceiroApplication.class, args);
	}

}
