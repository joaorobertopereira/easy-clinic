package br.com.helpcsistemas.paciente.cmd.api.commands;

import br.com.helpcsistemas.paciente.core.models.Paciente;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CadastrarPacienteCommand {

    @TargetAggregateIdentifier
    private String id;

    private Paciente paciente;
}
