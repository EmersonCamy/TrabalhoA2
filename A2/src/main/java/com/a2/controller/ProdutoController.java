package com.a2.controller;

import com.a2.modelo.Produto;
import com.a2.servico.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Indicar que esta classe é um controlador REST
@RestController
// Define a rota base para Produto
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Browse: Retorna todos os produtos
    // Mapeia solicitações GET para "/produtos"
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoService.browse();
        return ResponseEntity.ok(produtos); // Retorna a lista de produtos com status 200 OK
    }

    // Read: Busca um produto específico pelo código
    // Mapeia solicitações GET para "/produtos/{codigo}"
    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable int codigo) {
        Optional<Produto> produto = produtoService.read(codigo);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrado
    }

    // Add: Adiciona um novo produto
    // Mapeia solicitações POST para "/produtos"
    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto createdProduto = produtoService.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto); // Retorna o produto criado com status 201
    }

    // Edit: Atualiza um produto existente
    // Mapeia solicitações PUT para "/produtos/{codigo}"
    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> updateProduto(@PathVariable int codigo, @RequestBody Produto produto) {
        if (!produtoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        Produto updatedProduto = produtoService.edit(codigo, produto);
        return ResponseEntity.ok(updatedProduto); // Retorna o produto atualizado com status 200
    }

    // Delete: Remove um produto pelo código
    // Mapeia solicitações DELETE para "/produtos/{codigo}"
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteProduto(@PathVariable int codigo) {
        if (!produtoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        produtoService.delete(codigo);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }
}
