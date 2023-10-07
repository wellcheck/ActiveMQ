package br.com.well.testeActiveMq.controller;

import br.com.well.testeActiveMq.dto.PessoaDTO;
import br.com.well.testeActiveMq.model.Pessoa;
import br.com.well.testeActiveMq.repository.FuncionarioRepository;
import br.com.well.testeActiveMq.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1")
public class MensagemController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PessoaService service;

    @GetMapping(value = "/ola")
    public String olaMundo(){
        return "Olá mundo";
    }

    @GetMapping(value = "/tudo")
    public ResponseEntity buscarTudo(Integer id){
        List<Pessoa> pessoaList = service.buscar(id);
        return ResponseEntity.ok(pessoaList);

    }

    @PostMapping()
    public ResponseEntity adicionar(@RequestBody Pessoa pessoa){
        Pessoa pessoa1 = service.adicionar(pessoa);
        return ResponseEntity.ok(pessoa1);
    }

    @GetMapping(value = "/dto")
    public ResponseEntity<List<PessoaDTO>> listarDto(){
       List<PessoaDTO> result = service.buscarDto();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarId(@PathVariable Integer id){
      Optional result = service.bucarId(id);
        return new ResponseEntity(result, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{name}/{idade}/{pais}")
    public ResponseEntity listarDTO2(@PathVariable String name,
                                     @PathVariable Integer idade,
                                     @PathVariable String pais){
        List<PessoaDTO> result = service.buscarDto2(name, idade, pais);
        System.out.println(result);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Pessoa> editar(@RequestBody Pessoa pessoa){
        service.autalizar(pessoa);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Integer id){
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
