package br.com.helpcsistemas.paciente.models;

import br.com.helpcsistemas.paciente.models.enums.Escolaridade;
import br.com.helpcsistemas.paciente.models.enums.EstadoCivil;
import br.com.helpcsistemas.paciente.models.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Paciente {

    @Id
    @Column(unique=true)
    private String id;
    private String nomeCompleto;
    private Date dtNascimento;
    @CPF
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
    @Email
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}
