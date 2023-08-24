package br.com.helpcsistemas.atendimento.producer

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MessageSender(private val rabbitTemplate: RabbitTemplate) {

    @Value("\${rabbit.queue}")
    lateinit var rabbitQueue: String

    fun sendMessage(cpf: String) {rabbitTemplate.convertAndSend(rabbitQueue, cpf)}
}