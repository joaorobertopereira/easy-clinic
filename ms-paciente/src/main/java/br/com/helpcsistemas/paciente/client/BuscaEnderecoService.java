package br.com.helpcsistemas.paciente.client;


import br.com.helpcsistemas.paciente.models.Endereco;
import org.springframework.stereotype.Service;

@Service
public class BuscaEnderecoService {

    private final BuscaEnderecoClient client;

    public BuscaEnderecoService(BuscaEnderecoClient client) {
        this.client = client;
        ;
    }

    public Endereco getEndereco(String cep) {
        return client.buscaEndereco(cep);
    }
}
