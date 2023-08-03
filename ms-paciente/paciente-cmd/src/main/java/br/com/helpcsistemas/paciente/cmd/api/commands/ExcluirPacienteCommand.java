package br.com.helpcsistemas.paciente.cmd.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class ExcluirPacienteCommand {
    @TargetAggregateIdentifier
    private String id;

}
