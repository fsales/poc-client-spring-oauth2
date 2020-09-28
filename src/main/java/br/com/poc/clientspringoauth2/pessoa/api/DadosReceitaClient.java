package br.com.poc.clientspringoauth2.pessoa.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cpfs", url = "${poc-oauth2.dados-receita.endpoint}")
public interface DadosReceitaClient {

     @RequestMapping(method = RequestMethod.POST,
             value = "${poc-oauth2.dados-receita.method-consulta}",
             consumes = MediaType.APPLICATION_JSON_VALUE)
     String consultaPorCPF(@PathVariable("listaCpf")
                                   String cpf);
}
