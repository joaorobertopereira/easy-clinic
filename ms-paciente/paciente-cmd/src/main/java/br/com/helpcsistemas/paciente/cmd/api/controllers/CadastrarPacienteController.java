package br.com.helpcsistemas.paciente.cmd.api.controllers;

import br.com.helpcsistemas.paciente.cmd.api.commands.CadastrarPacienteCommand;
import br.com.helpcsistemas.paciente.cmd.api.dto.PacienteResponse;
import br.com.helpcsistemas.paciente.core.client.BuscaEnderecoService;
import br.com.helpcsistemas.paciente.core.models.Endereco;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/paciente")
public class CadastrarPacienteController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;

    private final BuscaEnderecoService buscaEnderecoService;


    public CadastrarPacienteController(CommandGateway commandGateway, BuscaEnderecoService buscaEnderecoService) {
        this.commandGateway = commandGateway;
        this.buscaEnderecoService = buscaEnderecoService;
    }
    @PostMapping
    public ResponseEntity<PacienteResponse> cadastrarPaciente(@Valid @RequestBody CadastrarPacienteCommand command) {
        String id = UUID.randomUUID().toString();
        command.setId(id);
        try {
            Endereco endereco = buscaEnderecoService.getEndereco(command.getPaciente().getEndereco().getCep()).block();
            command.getPaciente().setEndereco(endereco);

            commandGateway.sendAndWait(command);
            String mensagem = "Paciente cadastrado com sucesso. ID: "+id;
            log.info(mensagem);
            return new ResponseEntity<>(PacienteResponse.builder().id(id).message(mensagem).build(), HttpStatus.CREATED);
        } catch (Exception ex) {
            String mensagemErro = "Erro ao cadastrar o Paciente. ID: "+id;
            log.error(ex.getMessage());
            return new ResponseEntity<>(PacienteResponse.builder().id(id).message(mensagemErro).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
