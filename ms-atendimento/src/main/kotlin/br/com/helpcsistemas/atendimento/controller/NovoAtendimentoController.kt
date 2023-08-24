package br.com.helpcsistemas.atendimento.controller

import br.com.helpcsistemas.atendimento.consumer.MessageReceiver
import br.com.helpcsistemas.atendimento.dto.PacienteDTO
import br.com.helpcsistemas.atendimento.model.Atendimento
import br.com.helpcsistemas.atendimento.producer.MessageSender
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/atendimento")
@RestController
class NovoAtendimentoController(private val messageSender: MessageSender, private val messageReceiver: MessageReceiver) {

    @RequestMapping(method = [RequestMethod.POST], produces = ["application/json"])
    fun novoAtendimento(@RequestBody atendimento: Atendimento): ResponseEntity<PacienteDTO> {
        LOGGER.info("[NovoAtendimentoController][INFO][novoAtendimento]-Mensagem: Início do Processo.")

        messageSender.sendMessage(atendimento.cpf)






        return ResponseEntity.ok()
    }
    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(NovoAtendimentoController::class.java.name)
    }
}