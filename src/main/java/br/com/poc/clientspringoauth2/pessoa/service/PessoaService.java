package br.com.poc.clientspringoauth2.pessoa.service;

import br.com.poc.clientspringoauth2.pessoa.api.DadosReceitaClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class PessoaService {

    private DadosReceitaClient dadosReceitaClient;

    public String dadosReceita(String cpf) {

        return dadosReceitaClient.consultaPorCPF(Collections.singletonList(cpf));
    }
}
