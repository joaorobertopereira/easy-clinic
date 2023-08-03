package br.com.helpcsistemas.paciente.controllers;

import br.com.helpcsistemas.paciente.commands.ExcluirPacienteCommand;
import br.com.helpcsistemas.paciente.dto.PacienteResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/paciente")
public class ExcluirPacienteController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;

    public ExcluirPacienteController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PacienteResponse> excluirPaciente(@PathVariable(value = "id") String id) {
        try {
            commandGateway.sendAndWait(new ExcluirPacienteCommand(id));
            String mensagem = "Paciente excluído com sucesso. ID: "+id;
            log.info(mensagem);
            return new ResponseEntity<>(PacienteResponse.builder().id(id).message(mensagem).build(), HttpStatus.OK);
        } catch (Exception ex) {
            String mensagemErro = "Erro ao excluir o Paciente. ID: "+id;
            log.error(ex.getMessage());
            return new ResponseEntity<>(PacienteResponse.builder().id(id).message(mensagemErro).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
