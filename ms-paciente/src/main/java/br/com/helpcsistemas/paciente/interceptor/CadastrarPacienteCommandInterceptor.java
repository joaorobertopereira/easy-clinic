package br.com.helpcsistemas.paciente.interceptor;

import br.com.helpcsistemas.paciente.commands.CadastrarPacienteCommand;
import br.com.helpcsistemas.paciente.models.Paciente;
import br.com.helpcsistemas.paciente.repository.PacienteRepository;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

@Component
public class CadastrarPacienteCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PacienteRepository repository;

    public CadastrarPacienteCommandInterceptor(PacienteRepository repository) {
        this.repository = repository;
    }

    @Nonnull
    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(@Nonnull List<? extends CommandMessage<?>> messages) {
        return (index, command) -> {
            log.info("Interceptor command: {}", command.getPayloadType());
            if (CadastrarPacienteCommand.class.equals(command.getPayloadType())) {
                CadastrarPacienteCommand cadastrarPacienteCommand = (CadastrarPacienteCommand) command.getPayload();
                Paciente paciente = repository.findByCpf(cadastrarPacienteCommand.getCpf());
                if (Objects.nonNull(paciente)) {
                    log.warn("Paciente já cadastrado. ID encontrado : "+ cadastrarPacienteCommand.getId());
                    throw new IllegalStateException("Paciente já cadastrado. ID encontrado : "+ cadastrarPacienteCommand.getId());
                }
            }
            return command;
        };
    }
}
