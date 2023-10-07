package br.com.well.testeActiveMq.service;

import br.com.well.testeActiveMq.dto.PessoaDTO;
import br.com.well.testeActiveMq.model.Pessoa;
import br.com.well.testeActiveMq.repository.FuncionarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private static final Logger log = LoggerFactory.getLogger(PessoaService.class);

    @Autowired
    private FuncionarioRepository pessoaRepository;

    public List<Pessoa> buscar(Integer id){
        List<Pessoa> pessoa = pessoaRepository.findAll();
        log.info("Listado todas as pessoas!");
        return pessoa;
    }

    public Optional bucarId(Integer id) {

        Optional pessoa = null;
        if (id != null) {
            pessoa = pessoaRepository.findById(id);
            log.info("Pessoa encontrada com sucesso {}", pessoa);
            return pessoa;
        }
        if (id == null && id.equals(0)) {
            log.error("Não foi possivel buscar a pessoa.");
        }

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
      if(id != null) {
          pessoaRepository.deleteById(id);
          log.info("Pessoa excluida com sucesso");
      }else {
          log.error("Não foi possivel localizar os dados da pessoa através do ID");
      }
      }

   public void autalizar(Pessoa pessoa){
        var result = pessoaRepository.getReferenceById(pessoa.getId());
        pessoaRepository.save(pessoa);
   }

    public List<PessoaDTO> buscarDto2(String name, Integer idade, String pais) {
       List<PessoaDTO> pessoaDTOS = pessoaRepository.findAll().stream()
               .map(PessoaDTO::new)
               .filter(e-> e.getName().equals(name) && e.getIdade().equals(idade) && e.getPais().equals(pais))
               .toList();
       pessoaDTOS.forEach(System.out::println);
       return pessoaDTOS;
    }

}

