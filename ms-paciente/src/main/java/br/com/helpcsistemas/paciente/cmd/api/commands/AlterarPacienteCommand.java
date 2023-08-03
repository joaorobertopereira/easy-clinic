package br.com.helpcsistemas.paciente.cmd.api.commands;

import br.com.helpcsistemas.paciente.core.models.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlterarPacienteCommand {

    @TargetAggregateIdentifier
    private String id;

    private Paciente paciente;
}
