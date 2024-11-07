package com.a2.controller;

import com.a2.modelo.Cliente;
import com.a2.servico.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Browse: Retorna todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.browse();
        return ResponseEntity.ok(clientes);
    }

    // Read: Busca um cliente específico pelo código
    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int codigo) {
        Optional<Cliente> cliente = clienteService.read(codigo);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add: Adiciona um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    // Edit: Atualiza um cliente existente
    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int codigo, @RequestBody Cliente cliente) {
        if (!clienteService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Cliente updatedCliente = clienteService.edit(codigo, cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    // Delete: Remove um cliente pelo código
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int codigo) {
        if (!clienteService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clienteService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
