package br.com.helpcsistemas.paciente.service;

import br.com.helpcsistemas.paciente.dto.PacienteDTO;

public interface PacienteQueryService {
    PacienteDTO findPacienteByCpf(String cpf);

}
