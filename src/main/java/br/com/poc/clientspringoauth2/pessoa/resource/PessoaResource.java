package br.com.poc.clientspringoauth2.pessoa.resource;

import br.com.poc.clientspringoauth2.pessoa.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoas")
@AllArgsConstructor
public class PessoaResource {

    private PessoaService pessoaService;

    @GetMapping("dados-receita/cpf/{cpf}")
    public ResponseEntity<String> dadosReceita(@PathVariable String cpf) {

        return ResponseEntity.ok(pessoaService.dadosReceita(cpf));
    }
}
