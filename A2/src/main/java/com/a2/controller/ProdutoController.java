package com.a2.controller;

import com.a2.modelo.Produto;
import com.a2.servico.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Browse
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoService.browse();
        return ResponseEntity.ok(produtos);
    }

    // Read
    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable int codigo) {
        Optional<Produto> produto = produtoService.read(codigo);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add
    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto createdProduto = produtoService.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
    }

    // Edit
    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> updateProduto(@PathVariable int codigo, @RequestBody Produto produto) {
        if (!produtoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Produto updatedProduto = produtoService.edit(codigo, produto);
        return ResponseEntity.ok(updatedProduto);
    }

    // Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteProduto(@PathVariable int codigo) {
        if (!produtoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
