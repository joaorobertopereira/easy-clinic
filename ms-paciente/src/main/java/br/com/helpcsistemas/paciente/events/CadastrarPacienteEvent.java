package br.com.helpcsistemas.paciente.events;

import br.com.helpcsistemas.paciente.models.Paciente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CadastrarPacienteEvent {
    private String id;
    private Paciente paciente;
}
