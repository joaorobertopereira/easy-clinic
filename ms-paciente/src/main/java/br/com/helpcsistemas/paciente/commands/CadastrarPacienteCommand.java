package br.com.helpcsistemas.paciente.commands;

import br.com.helpcsistemas.paciente.models.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarPacienteCommand {

    @TargetAggregateIdentifier
    private String id;

    private Paciente paciente;
}
