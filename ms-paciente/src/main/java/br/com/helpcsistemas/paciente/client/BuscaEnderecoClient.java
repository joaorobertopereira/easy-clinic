package br.com.helpcsistemas.paciente.client;

import br.com.helpcsistemas.paciente.models.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "buscaEndereco", url = "${api-busca-cep.url}")
public interface BuscaEnderecoClient {

    @GetMapping(value = "/{cep}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    Endereco buscaEndereco(@PathVariable("cep") String cep);
}
