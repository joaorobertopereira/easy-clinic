package br.com.helpcsistemas.paciente.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcluirPacienteCommand {
    @TargetAggregateIdentifier
    private String id;

}
