package br.com.helpcsistemas.atendimento.consumer

import br.com.helpcsistemas.atendimento.dto.PacienteDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageReceiver {
    @RabbitListener(queues = ["\${rabbit.queue}"])
    fun receiveMessage(paciente: PacienteDTO) {
        LOGGER.info("[Consumer][INFO]-Mensagem: $paciente")

    }

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(MessageReceiver::class.java.name)
    }
}