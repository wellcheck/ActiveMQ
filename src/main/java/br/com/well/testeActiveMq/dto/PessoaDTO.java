package br.com.well.testeActiveMq.dto;

import br.com.well.testeActiveMq.model.Pessoa;
import br.com.well.testeActiveMq.service.PessoaService;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PessoaDTO {

    private Integer id;
    private String name;
    private Integer idade;
    private String pais;

    public PessoaDTO (Pessoa pessoa){
        id = pessoa.getId();
        name = pessoa.getName();
        idade = pessoa.getIdade();
        pais = pessoa.getPais();
    }

}
