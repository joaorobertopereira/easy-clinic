package br.com.helpcsistemas.paciente.repository;

import br.com.helpcsistemas.paciente.models.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, String> {

    Paciente findByCpf(String cpf);
}
