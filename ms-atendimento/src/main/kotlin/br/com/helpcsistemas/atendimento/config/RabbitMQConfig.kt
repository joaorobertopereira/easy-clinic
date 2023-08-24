package br.com.helpcsistemas.atendimento.config

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Value("\${rabbit.queue}")
    lateinit var rabbitQueue: String

    @Value("\${rabbit.dead-letter}")
    lateinit var rabbitDeadLetterQueue: String

    @Bean
    fun myQueue(): Queue {return Queue(rabbitQueue)}
    @Bean
    fun myDeadLetterQueue(): Queue {return Queue(rabbitDeadLetterQueue)}
}