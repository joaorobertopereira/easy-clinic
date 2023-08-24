package br.com.helpcsistemas.paciente.mapper;

import br.com.helpcsistemas.paciente.dto.PacienteDTO;
import br.com.helpcsistemas.paciente.models.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeCompleto", source = "nomeCompleto")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "celular", source = "celular")
    @Mapping(target = "email", source = "email")
    PacienteDTO pacienteToDTO(Paciente paciente);
}
