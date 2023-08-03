package br.com.helpcsistemas.paciente.cmd.api.controllers;

import br.com.helpcsistemas.paciente.cmd.api.commands.AlterarPacienteCommand;
import br.com.helpcsistemas.paciente.cmd.api.dto.PacienteResponse;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/paciente")
public class AlterarPacienteController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;
    public AlterarPacienteController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PacienteResponse> alterarPaciente(@PathVariable(value = "id") String id, @Valid @RequestBody AlterarPacienteCommand command) {
        try {
            command.setId(id);
            commandGateway.sendAndWait(command);
            String mensagem = "Paciente alterado com sucesso. ID: "+id;
            log.info(mensagem);
            return new ResponseEntity<>(PacienteResponse.builder().id(id).message(mensagem).build(), HttpStatus.OK);
        } catch (Exception ex) {
            String mensagemErro = "Erro ao alterar o Paciente. ID: "+id;
            log.error(ex.getMessage());
            return new ResponseEntity<>(PacienteResponse.builder().id(id).message(mensagemErro).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
