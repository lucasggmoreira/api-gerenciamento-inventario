package me.lucasggmoreira.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.lucasggmoreira.domain.produto.DadosDetalhadosProduto;
import me.lucasggmoreira.domain.produto.DadosMudancaProduto;
import me.lucasggmoreira.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos/{id}")
public class ProdutoIndividualController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosProduto> modificarProduto(@PathVariable long id, @RequestBody @Valid DadosMudancaProduto json){
        var produto = produtoRepository.getReferenceById(id);
        produto.alterarDados(json);
        return ResponseEntity.ok(new DadosDetalhadosProduto(produto));
    }

    @GetMapping
    public ResponseEntity<DadosDetalhadosProduto> listarProduto(@PathVariable long id){
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosProduto(produto));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> deletarProduto(@PathVariable long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
