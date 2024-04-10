package one.digitalInovation.api_padroes_de_projetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiPadroesDeProjetosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPadroesDeProjetosApplication.class, args);
	}
}
