package br.com.helpcsistemas.atendimento.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteDTO {
    private String id;
    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private String celular;
    private String email;
}
