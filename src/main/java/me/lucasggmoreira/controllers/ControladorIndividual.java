package me.lucasggmoreira.controllers;

import me.lucasggmoreira.repository.Repositorio;
import me.lucasggmoreira.exceptions.ProdutoExistenteException;
import me.lucasggmoreira.exceptions.ProdutoNaoEncontradoException;
import me.lucasggmoreira.exceptions.ValorInvalidoException;
import me.lucasggmoreira.exceptions.ValorNuloException;
import me.lucasggmoreira.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos/{id}")
public class ControladorIndividual {

    @Autowired
    private Repositorio repositorio;

    @PutMapping
    public ResponseEntity<String> modificarProduto(@PathVariable long id, @RequestBody Produto json){
        try {
            if(repositorio.findById(id).isEmpty()){
                throw new ProdutoNaoEncontradoException("Produto não encontrado!");
            }
            Produto produto = repositorio.findById(id).get();
            produto.alterarDados(json, id, repositorio); // Mudar para não repetir o nome
            repositorio.save(produto);
            return ResponseEntity.ok("Produto atualizado!");
        } catch (ProdutoExistenteException | ValorInvalidoException | ValorNuloException |
                 ProdutoNaoEncontradoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity listarProduto(@PathVariable long id){
        try {
            if (repositorio.findById(id).isEmpty()) {
                throw new ProdutoNaoEncontradoException("Produto não encontrado!");
            }
        } catch (ProdutoNaoEncontradoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        Produto produtos = repositorio.findById(id).get();
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping
    public ResponseEntity<String> deletarProduto(@PathVariable long id){
        try {
            if (repositorio.findById(id).isEmpty()) {
                throw new ProdutoNaoEncontradoException("Produto não encontrado!");
            }
        } catch (ProdutoNaoEncontradoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        repositorio.deleteById(id);
        return ResponseEntity.ok("Produto removido com sucesso!");
    }

    @PatchMapping("/estoque")
    public ResponseEntity<String> modificarEstoqueProduto(@PathVariable long id, @RequestBody Produto json){
        try {
            if(repositorio.findById(id).isEmpty()){
                throw new ProdutoNaoEncontradoException("Produto não encontrado!");
            }
            Produto produto = repositorio.findById(id).get();
            produto.setQuantidade(json.getQuantidade());
            repositorio.save(produto);
            return ResponseEntity.ok("Estoque do produto atualizado!");
        } catch (ValorInvalidoException | ValorNuloException |
                 ProdutoNaoEncontradoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/preco")
    public ResponseEntity<String> modificarPrecoProduto(@PathVariable long id, @RequestBody Produto json){
        try {
            if(repositorio.findById(id).isEmpty()){
                throw new ProdutoNaoEncontradoException("Produto não encontrado!");
            }
            Produto produto = repositorio.findById(id).get();
            produto.setPreco(json.getPreco());
            repositorio.save(produto);
            return ResponseEntity.ok("Preco do produto atualizado!");
        } catch (ValorInvalidoException | ValorNuloException |
                 ProdutoNaoEncontradoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
