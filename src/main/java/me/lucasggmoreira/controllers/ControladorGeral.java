package me.lucasggmoreira.controllers;

import me.lucasggmoreira.repository.Repositorio;
import me.lucasggmoreira.exceptions.ProdutoExistenteException;
import me.lucasggmoreira.exceptions.ValorInvalidoException;
import me.lucasggmoreira.exceptions.ValorNuloException;
import me.lucasggmoreira.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ControladorGeral {

    @Autowired
    private Repositorio repositorio;

    @PostMapping
    public ResponseEntity<String> cadastrarProduto(@RequestBody Produto json){
        try{
            Produto produto = new Produto(json, repositorio);
            repositorio.save(produto);
            return ResponseEntity.ok("Produto cadastrado!");
        } catch (ProdutoExistenteException  | ValorInvalidoException  | ValorNuloException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity listarProdutos(){
        Iterable<Produto> produtos = repositorio.findAll();
        if (repositorio.findAll().isEmpty()) return ResponseEntity.badRequest().body("O banco de dados está vazio!");
        return ResponseEntity.ok(produtos);
    }




}
