package br.com.well.testeActiveMq.service;

import br.com.well.testeActiveMq.dto.PessoaDTO;
import br.com.well.testeActiveMq.model.Pessoa;
import br.com.well.testeActiveMq.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private FuncionarioRepository pessoaRepository;

    public List<Pessoa> buscar(){
        List<Pessoa> pessoa = pessoaRepository.findAll();
        return pessoa;
    }

    public Pessoa adicionar(Pessoa pessoa){
        Pessoa pessoaList = pessoaRepository.save(pessoa);
        return pessoaList;
    }

    public List<PessoaDTO> buscarDto(){
      return pessoaRepository.findAll().stream().map(PessoaDTO::new).toList();
    }

    public void deletar(Integer id){
        pessoaRepository.deleteById(id);
    }

   public void autalizar(Pessoa pessoa){
        var result = pessoaRepository.getReferenceById(pessoa.getId());
        pessoaRepository.save(pessoa);
   }

    public void buscarDto2(String name, Integer idade, String pais) {
       
    }


}

