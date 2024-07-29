package me.lucasggmoreira.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import me.lucasggmoreira.repository.Repositorio;
import me.lucasggmoreira.exceptions.ProdutoExistenteException;
import me.lucasggmoreira.exceptions.ValorInvalidoException;
import me.lucasggmoreira.exceptions.ValorNuloException;

@Setter
@Getter
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private double preco;

    private int quantidade;

    public Produto() {
    }

    public Produto(Produto produto, Repositorio repositorio) {
        if (!nomeEValido(produto)) throw new ValorNuloException("O nome não pode estar vazio!");
        if (nomeJaExiste(produto, repositorio)) throw new ProdutoExistenteException("Produto ja existe no estoque!");
        validarEstoque(produto);
        this.preco = produto.getPreco();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
    }

    public void alterarDados(Produto produto, Long id, Repositorio repositorio) {
        for (int i = 0; i < repositorio.findAll().size(); i++) {
            if (repositorio.findAll().get(i).getNome().equalsIgnoreCase(produto.getNome()) && (!id.equals(produto.getId()))){
                throw new ProdutoExistenteException("Outro produto ja tem esse nome!");
            }
        }
        this.id = id;
        this.preco = produto.getPreco();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
    }


    private boolean nomeEValido(Produto produto) {
        return (produto.getNome() != null) && (!produto.getNome().isEmpty());
    }

    private boolean nomeJaExiste(Produto produto, Repositorio repositorio) {
        for (int i = 0; i < repositorio.findAll().size(); i++) {
            if (repositorio.findAll().get(i).nome.equalsIgnoreCase(produto.getNome())) return true;
        }
        return false;
    }

    private void validarEstoque(Produto produto){
        if (produto.preco == 0) throw new ValorInvalidoException("O preço não pode ser gratuito!");
        else if (produto.preco < 0) throw new ValorInvalidoException("O preço não pode ser negativo!");
        if (produto.getQuantidade() < 0) throw new ValorInvalidoException("A quantidade de estoque não pode ser negativa!");
    }
}
