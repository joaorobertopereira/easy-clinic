package br.com.helpcsistemas.paciente.cmd.api.events;

import br.com.helpcsistemas.paciente.core.models.Paciente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarPacienteEvent {
    private String id;
    private Paciente paciente;
}
