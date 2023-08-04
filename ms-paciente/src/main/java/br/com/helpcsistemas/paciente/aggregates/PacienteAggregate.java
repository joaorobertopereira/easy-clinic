package br.com.helpcsistemas.paciente.aggregates;

import br.com.helpcsistemas.paciente.commands.AlterarPacienteCommand;
import br.com.helpcsistemas.paciente.commands.CadastrarPacienteCommand;
import br.com.helpcsistemas.paciente.commands.ExcluirPacienteCommand;
import br.com.helpcsistemas.paciente.events.AlterarPacienteEvent;
import br.com.helpcsistemas.paciente.events.CadastrarPacienteEvent;
import br.com.helpcsistemas.paciente.events.ExcluirPacienteEvent;
import br.com.helpcsistemas.paciente.models.Endereco;
import br.com.helpcsistemas.paciente.models.enums.Escolaridade;
import br.com.helpcsistemas.paciente.models.enums.EstadoCivil;
import br.com.helpcsistemas.paciente.models.enums.Genero;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

@Aggregate
@NoArgsConstructor
public class PacienteAggregate {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @AggregateIdentifier
    private String id;
    private String nomeCompleto;
    private Date dtNascimento;
    private String cpf;
    private Genero genero;
    private Long rg;
    private Boolean extrangeiro;
    private String naturalidade;
    private EstadoCivil estadoCivil;
    private Double altura;
    private Double peso;
    private String profissao;
    private Escolaridade escolaridade;
    private String telefone;
    private String celular;
    private String email;
    private Endereco endereco;

    @CommandHandler
    public PacienteAggregate(CadastrarPacienteCommand command) {
        log.info("Cadastrar Paciente - {}", command.getNomeCompleto());
        AggregateLifecycle.apply(
                    CadastrarPacienteEvent.builder()
                        .id(command.getId())
                        .nomeCompleto(command.getNomeCompleto())
                        .dtNascimento(command.getDtNascimento())
                        .cpf(command.getCpf())
                        .genero(command.getGenero())
                        .rg(command.getRg())
                        .extrangeiro(command.getExtrangeiro())
                        .naturalidade(command.getNaturalidade())
                        .estadoCivil(command.getEstadoCivil())
                        .altura(command.getAltura())
                        .peso(command.getPeso())
                        .profissao(command.getProfissao())
                        .escolaridade(command.getEscolaridade())
                        .telefone(command.getTelefone())
                        .celular(command.getCelular())
                        .email(command.getEmail())
                        .endereco(command.getEndereco())
                    .build()
                    );
    }
    @EventSourcingHandler
    public void on(CadastrarPacienteEvent event) {
        this.id = event.getId();
        this.nomeCompleto = event.getNomeCompleto();
        this.dtNascimento = event.getDtNascimento();
        this.cpf = event.getCpf();
        this.genero = event.getGenero();
        this.rg = event.getRg();
        this.extrangeiro = event.getExtrangeiro();
        this.naturalidade = event.getNaturalidade();
        this.estadoCivil = event.getEstadoCivil();
        this.altura = event.getAltura();
        this.peso = event.getPeso();
        this.profissao = event.getProfissao();
        this.escolaridade = event.getEscolaridade();
        this.telefone = event.getTelefone();
        this.celular = event.getCelular();
        this.email = event.getEmail();
        this.endereco = event.getEndereco();
    }
    @CommandHandler
    public void handler(AlterarPacienteCommand command) {
        log.info("Alterar Paciente - {}", command.getNomeCompleto());

        AggregateLifecycle.apply(
                AlterarPacienteEvent.builder()
                        .id(UUID.randomUUID().toString())
                        .nomeCompleto(command.getNomeCompleto())
                        .dtNascimento(command.getDtNascimento())
                        .cpf(command.getCpf())
                        .genero(command.getGenero())
                        .rg(command.getRg())
                        .extrangeiro(command.getExtrangeiro())
                        .naturalidade(command.getNaturalidade())
                        .estadoCivil(command.getEstadoCivil())
                        .altura(command.getAltura())
                        .peso(command.getPeso())
                        .profissao(command.getProfissao())
                        .escolaridade(command.getEscolaridade())
                        .telefone(command.getTelefone())
                        .celular(command.getCelular())
                        .email(command.getEmail())
                        .endereco(command.getEndereco())
                        .build()
        );
    }
    @EventSourcingHandler
    public void on(AlterarPacienteEvent event) {
        this.id = event.getId();
        this.nomeCompleto = event.getNomeCompleto();
        this.dtNascimento = event.getDtNascimento();
        this.cpf = event.getCpf();
        this.genero = event.getGenero();
        this.rg = event.getRg();
        this.extrangeiro = event.getExtrangeiro();
        this.naturalidade = event.getNaturalidade();
        this.estadoCivil = event.getEstadoCivil();
        this.altura = event.getAltura();
        this.peso = event.getPeso();
        this.profissao = event.getProfissao();
        this.escolaridade = event.getEscolaridade();
        this.telefone = event.getTelefone();
        this.celular = event.getCelular();
        this.email = event.getEmail();
        this.endereco = event.getEndereco();
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
