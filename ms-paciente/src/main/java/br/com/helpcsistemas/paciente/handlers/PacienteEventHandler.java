package br.com.helpcsistemas.paciente.handlers;

import br.com.helpcsistemas.paciente.events.AlterarPacienteEvent;
import br.com.helpcsistemas.paciente.events.CadastrarPacienteEvent;
import br.com.helpcsistemas.paciente.events.ExcluirPacienteEvent;

public interface PacienteEventHandler {
    void on(CadastrarPacienteEvent event);
    void on(AlterarPacienteEvent event);
    void on(ExcluirPacienteEvent event);
}
