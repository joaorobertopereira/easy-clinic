package br.com.helpcsistemas.paciente.cmd.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteResponse {
    private String id;
    private String message;
}
