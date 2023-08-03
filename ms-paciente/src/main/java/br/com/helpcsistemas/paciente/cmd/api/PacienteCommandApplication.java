package br.com.helpcsistemas.paciente.cmd.api;

import br.com.helpcsistemas.paciente.cmd.api.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(AxonConfig.class)
public class PacienteCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteCommandApplication.class, args);
	}

}
