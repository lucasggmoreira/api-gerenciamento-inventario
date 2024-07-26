package me.lucasggmoreira.controladores;

import me.lucasggmoreira.exceptions.ProdutoExistenteException;
import me.lucasggmoreira.exceptions.ValorInvalidoException;
import me.lucasggmoreira.exceptions.ValorNuloException;
import me.lucasggmoreira.modelos.Produto;
import me.lucasggmoreira.InventarioProdutos.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ControladorProdutos {

    @Autowired
    private Repositorio repositorio;

    @PostMapping
    public ResponseEntity<String> cadastrarProduto(@RequestBody Produto json){
        try{
            Produto produto = new Produto(json, repositorio);
            repositorio.save(produto);
            return ResponseEntity.ok("Produto cadastrado!");
        } catch (ProdutoExistenteException  | ValorInvalidoException  | ValorNuloException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Produto>> listarProdutos(){
        Iterable<Produto> produtos = repositorio.findAll();
        return ResponseEntity.ok(produtos);
    }

}
