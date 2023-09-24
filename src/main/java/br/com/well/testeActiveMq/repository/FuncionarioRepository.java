package br.com.well.testeActiveMq.repository;

import br.com.well.testeActiveMq.dto.PessoaDTO;
import br.com.well.testeActiveMq.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface FuncionarioRepository extends JpaRepository<Pessoa ,  Integer> {


  //  List<Pessoa> buscarDto();
}
