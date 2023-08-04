package br.com.helpcsistemas.paciente.handlers;

import br.com.helpcsistemas.paciente.events.AlterarPacienteEvent;
import br.com.helpcsistemas.paciente.events.CadastrarPacienteEvent;
import br.com.helpcsistemas.paciente.events.ExcluirPacienteEvent;
import br.com.helpcsistemas.paciente.models.Paciente;
import br.com.helpcsistemas.paciente.repository.PacienteRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("paciente-group")
public class PacienteEventHandlerImpl implements PacienteEventHandler{

    private final PacienteRepository repository;

    public PacienteEventHandlerImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    @EventHandler
    public void on(CadastrarPacienteEvent event) {
        repository.save(criarPaciente(event));
    }

    @Override
    @EventHandler
    public void on(AlterarPacienteEvent event) {
        repository.save(criarPaciente(event)); }

    @Override
    @EventHandler
    public void on(ExcluirPacienteEvent event) {
        repository.deleteById(event.getId());
    }

    private Paciente criarPaciente(CadastrarPacienteEvent event) {
        return Paciente.builder()
                .id(event.getId())
                .nomeCompleto(event.getNomeCompleto())
                .dtNascimento(event.getDtNascimento())
                .cpf(event.getCpf())
                .genero(event.getGenero())
                .rg(event.getRg())
                .extrangeiro(event.getExtrangeiro())
                .naturalidade(event.getNaturalidade())
                .estadoCivil(event.getEstadoCivil())
                .altura(event.getAltura())
                .peso(event.getPeso())
                .profissao(event.getProfissao())
                .escolaridade(event.getEscolaridade())
                .telefone(event.getTelefone())
                .celular(event.getCelular())
                .email(event.getEmail())
                .endereco(event.getEndereco())
                .build();
    }

    private Paciente criarPaciente(AlterarPacienteEvent event) {
        return Paciente.builder()
                .id(event.getId())
                .nomeCompleto(event.getNomeCompleto())
                .dtNascimento(event.getDtNascimento())
                .cpf(event.getCpf())
                .genero(event.getGenero())
                .rg(event.getRg())
                .extrangeiro(event.getExtrangeiro())
                .naturalidade(event.getNaturalidade())
                .estadoCivil(event.getEstadoCivil())
                .altura(event.getAltura())
                .peso(event.getPeso())
                .profissao(event.getProfissao())
                .escolaridade(event.getEscolaridade())
                .telefone(event.getTelefone())
                .celular(event.getCelular())
                .email(event.getEmail())
                .endereco(event.getEndereco())
                .build();
    }
}
