package me.lucasggmoreira.domain.produto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Produto {

    @Id
    @SequenceGenerator(name = "produtos_seq", sequenceName = "produtos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_seq")
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
    }

    public void alterarDados(DadosMudancaProduto produto) {
        if (produto.nome() != null) this.nome = produto.nome();
        if (produto.preco() != null) this.preco = produto.preco();
        if (produto.quantidade() != null) this.quantidade = produto.quantidade();
    }

}
