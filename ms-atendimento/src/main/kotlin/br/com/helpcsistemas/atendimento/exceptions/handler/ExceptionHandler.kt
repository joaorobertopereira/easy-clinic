package br.com.helpcsistemas.atendimento.exceptions.handler

import br.com.helpcsistemas.atendimento.exceptions.ExceptionResponse
import br.com.helpcsistemas.atendimento.exceptions.NotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.ServerWebExchange

@ControllerAdvice
class ExceptionHandler  {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundExceptions(ex: NotFoundException, exchange: ServerWebExchange) :
            ResponseEntity<ExceptionResponse> {

        val exceptionResponse = ExceptionResponse(
            HttpStatus.NOT_FOUND.value() ,
            ex.message
        )
        LOGGER.error("[Handler][NOT-FOUND]-Message: Not Found.")
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(ExceptionHandler::class.java.name)
    }
}