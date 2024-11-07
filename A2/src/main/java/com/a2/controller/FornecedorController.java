package com.a2.controller;

import com.a2.modelo.Fornecedor;
import com.a2.servico.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    // Browse: Retorna todos os fornecedores
    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAllFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.browse();
        return ResponseEntity.ok(fornecedores);
    }

    // Read: Busca um fornecedor específico pelo código
    @GetMapping("/{codigo}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable int codigo) {
        Optional<Fornecedor> fornecedor = fornecedorService.read(codigo);
        return fornecedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add: Adiciona um novo fornecedor
    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor createdFornecedor = fornecedorService.add(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFornecedor);
    }

    // Edit: Atualiza um fornecedor existente
    @PutMapping("/{codigo}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable int codigo, @RequestBody Fornecedor fornecedor) {
        if (!fornecedorService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Fornecedor updatedFornecedor = fornecedorService.edit(codigo, fornecedor);
        return ResponseEntity.ok(updatedFornecedor);
    }

    // Delete: Remove um fornecedor pelo código
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable int codigo) {
        if (!fornecedorService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fornecedorService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
