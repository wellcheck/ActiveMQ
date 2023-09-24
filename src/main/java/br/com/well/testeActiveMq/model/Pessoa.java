package br.com.well.testeActiveMq.model;

import br.com.well.testeActiveMq.dto.PessoaDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer idade;

    private String sexo;

    private String cidade;

    private String estado;

    private String pais;


    public Pessoa(PessoaDTO pessoaDTO) {
    }

}
