package br.com.helpcsistemas.paciente.service;

import br.com.helpcsistemas.paciente.dto.PacienteDTO;
import br.com.helpcsistemas.paciente.mapper.PacienteMapper;
import br.com.helpcsistemas.paciente.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteQueryServiceImpl implements PacienteQueryService {

    private final PacienteRepository repository;

    public PacienteQueryServiceImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public PacienteDTO findPacienteByCpf(String cpf) {
        return PacienteMapper.INSTANCE.pacienteToDTO(repository.findByCpf(cpf));
    }
}
