package br.com.helpcsistemas.paciente.cmd.api.aggregates;

import br.com.helpcsistemas.paciente.cmd.api.commands.AlterarPacienteCommand;
import br.com.helpcsistemas.paciente.cmd.api.commands.CadastrarPacienteCommand;
import br.com.helpcsistemas.paciente.cmd.api.commands.ExcluirPacienteCommand;
import br.com.helpcsistemas.paciente.core.events.AlterarPacienteEvent;
import br.com.helpcsistemas.paciente.core.events.CadastrarPacienteEvent;
import br.com.helpcsistemas.paciente.core.events.ExcluirPacienteEvent;
import br.com.helpcsistemas.paciente.core.models.Paciente;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
public class PacienteAggregate {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @AggregateIdentifier
    private String id;

    private Paciente paciente;

    @CommandHandler
    public PacienteAggregate(CadastrarPacienteCommand command) {
        log.info("Cadastrar Paciente - {}", command.getPaciente().getNomeCompleto());
        CadastrarPacienteEvent event = CadastrarPacienteEvent.builder()
                .id(command.getId())
                .paciente(command.getPaciente())
                .build();
        AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on(CadastrarPacienteEvent event) {
        this.id = event.getId();
        this.paciente = event.getPaciente();
    }

    @CommandHandler
    public void handler(AlterarPacienteCommand command) {
        log.info("Alterar Paciente - {}", command.getPaciente().getNomeCompleto());
        AlterarPacienteEvent event = AlterarPacienteEvent.builder()
                .id(UUID.randomUUID().toString())
                .paciente(command.getPaciente())
                .build();

        AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on(AlterarPacienteEvent event) {
        this.id = event.getId();
        this.paciente = event.getPaciente();
    }

    @CommandHandler
    public void handler(ExcluirPacienteCommand command) {
        log.info("Excluir Paciente - {}", command.getId());
        ExcluirPacienteEvent event = new ExcluirPacienteEvent();
        event.setId(command.getId());

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ExcluirPacienteEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
