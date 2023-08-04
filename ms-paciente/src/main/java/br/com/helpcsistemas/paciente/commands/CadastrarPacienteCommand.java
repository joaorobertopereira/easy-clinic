package br.com.helpcsistemas.paciente.commands;

import br.com.helpcsistemas.paciente.models.Endereco;
import br.com.helpcsistemas.paciente.models.enums.Escolaridade;
import br.com.helpcsistemas.paciente.models.enums.EstadoCivil;
import br.com.helpcsistemas.paciente.models.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarPacienteCommand {
    @TargetAggregateIdentifier
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
}
