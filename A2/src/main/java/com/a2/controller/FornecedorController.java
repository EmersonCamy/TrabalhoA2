package com.a2.controller;

import com.a2.modelo.Fornecedor;
import com.a2.servico.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Indicar que esta classe é um controlador REST
@RestController
// Define a rota base para Fornecedores
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    // Browse: Retorna todos os fornecedores
    // Mapeia solicitações GET para "/fornecedores"
    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAllFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.browse();
        return ResponseEntity.ok(fornecedores); // Retorna a lista de fornecedores com status 200 OK
    }

    // Read: Busca um fornecedor específico pelo código
    // Mapeia solicitações GET para "/fornecedores/{codigo}"
    @GetMapping("/{codigo}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable int codigo) {
        Optional<Fornecedor> fornecedor = fornecedorService.read(codigo);
        return fornecedor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrado
    }

    // Add: Adiciona um novo fornecedor
    // Mapeia solicitações POST para "/fornecedores"
    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor createdFornecedor = fornecedorService.add(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFornecedor); // Retorna o fornecedor criado com status 201
    }

    // Edit: Atualiza um fornecedor existente
    // Mapeia solicitações PUT para "/fornecedores/{codigo}"
    @PutMapping("/{codigo}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable int codigo, @RequestBody Fornecedor fornecedor) {
        if (!fornecedorService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        Fornecedor updatedFornecedor = fornecedorService.edit(codigo, fornecedor);
        return ResponseEntity.ok(updatedFornecedor); // Retorna o fornecedor atualizado com status 200
    }

    // Delete: Remove um fornecedor pelo código
    // Mapeia solicitações DELETE para "/fornecedores/{codigo}"
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable int codigo) {
        if (!fornecedorService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        fornecedorService.delete(codigo);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }
}
