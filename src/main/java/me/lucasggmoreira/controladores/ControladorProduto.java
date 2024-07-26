package me.lucasggmoreira.controladores;

import me.lucasggmoreira.InventarioProdutos.Repositorio;
import me.lucasggmoreira.exceptions.ProdutoExistenteException;
import me.lucasggmoreira.exceptions.ProdutoNaoEncontradoException;
import me.lucasggmoreira.exceptions.ValorInvalidoException;
import me.lucasggmoreira.exceptions.ValorNuloException;
import me.lucasggmoreira.modelos.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos/{id}")
public class ControladorProduto {

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
    public ResponseEntity<Iterable<Produto>> listarProdutos(@PathVariable String id){
        Iterable<Produto> produtos = repositorio.findAll();
        return ResponseEntity.ok(produtos);
    }


}
