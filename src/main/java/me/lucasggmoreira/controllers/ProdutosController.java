package me.lucasggmoreira.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.lucasggmoreira.domain.produto.DadosCadastroProduto;
import me.lucasggmoreira.domain.produto.DadosDetalhadosProduto;
import me.lucasggmoreira.domain.produto.ProdutoRepository;
import me.lucasggmoreira.domain.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosProduto> cadastrarProduto(@Valid @RequestBody DadosCadastroProduto dados, UriComponentsBuilder uriBuilder){
        var produto = new Produto(dados);
        produtoRepository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosProduto(produto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhadosProduto>> listarProdutos(@PageableDefault(size = 10) Pageable paginacao){
        var produtos = produtoRepository.findAll(paginacao).map(DadosDetalhadosProduto::new);
        return ResponseEntity.ok(produtos);
    }




}
