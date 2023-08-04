package br.com.helpcsistemas.paciente;

import br.com.helpcsistemas.paciente.exception.handler.PacienteEventsErrorHandler;
import br.com.helpcsistemas.paciente.interceptor.CadastrarPacienteCommandInterceptor;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteApplication.class, args);
	}
	@Autowired
	public void registerCreateProductCommandInterceptor(ApplicationContext context,
														CommandBus commandBus) {
		commandBus.registerDispatchInterceptor(context.getBean(CadastrarPacienteCommandInterceptor.class));

	}
	@Autowired
	public void configure(EventProcessingConfigurer config) {
		config.registerListenerInvocationErrorHandler("paciente-group",
				conf -> new PacienteEventsErrorHandler());
	}
}
