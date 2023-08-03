package br.com.helpcsistemas.paciente.core.client;


import br.com.helpcsistemas.paciente.core.models.Endereco;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BuscaEnderecoService {

    private final WebClient webClient;

    public BuscaEnderecoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Endereco> getEndereco(String cep) {
        return webClient.get()
                .uri("/"+cep+"/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Endereco.class);
    }
}
