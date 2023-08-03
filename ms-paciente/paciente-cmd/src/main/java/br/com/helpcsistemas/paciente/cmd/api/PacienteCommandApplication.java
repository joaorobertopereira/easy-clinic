package br.com.helpcsistemas.paciente.cmd.api;

import br.com.helpcsistemas.paciente.core.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Import(AxonConfig.class)
public class PacienteCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteCommandApplication.class, args);
	}

}
