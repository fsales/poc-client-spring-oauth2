package br.com.poc.clientspringoauth2.pessoa.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoas")
public class PessoaResource {

    @GetMapping("dados-receita/cpf/{cpf}")
    public ResponseEntity<String> dadosReceita(@PathVariable String cpf){

        return ResponseEntity.ok(cpf);
    }
}
