package br.com.helpcsistemas.paciente.messager.consumer;

import br.com.helpcsistemas.paciente.dto.PacienteDTO;
import br.com.helpcsistemas.paciente.messager.producer.RabbitMQProducer;
import br.com.helpcsistemas.paciente.service.PacienteQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Value("${rabbit.queue}")
    private final String exchangeName;

    private final PacienteQueryService pacienteQueryService;

    private final RabbitMQProducer rabbitMQProducer;

    public RabbitMQConsumer(String exchangeName, PacienteQueryService pacienteQueryService, RabbitMQProducer rabbitMQProducer) {
        this.exchangeName = exchangeName;
        this.pacienteQueryService = pacienteQueryService;
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @RabbitListener(queues = {"${rabbit.queue}"})
    public void consumeMessage(String cpf) {
        PacienteDTO pacienteDTO = pacienteQueryService.findPacienteByCpf(cpf);
        rabbitMQProducer.send(exchangeName, pacienteDTO.getId(), pacienteDTO);
        log.info("[RabbitMQConsumer][INFO][Consulta][Paciente]-Mensagem: Consulta realizada com sucesso.");
    }
}
