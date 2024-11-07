package com.a2.controller;

import com.a2.modelo.Cliente;
import com.a2.servico.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Indicar que esta classe é um controlador REST
@RestController
// Define a rota base para clientes
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Browse: Retorna todos os clientes
    // Mapeia solicitações GET para "/clientes"
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.browse();
        return ResponseEntity.ok(clientes); // Retorna a lista de clientes com status 200 OK
    }

    // Read: Busca um cliente específico pelo código
    // Mapeia solicitações GET para "/clientes/{codigo}"
    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int codigo) {
        Optional<Cliente> cliente = clienteService.read(codigo);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrado
    }

    // Add: Adiciona um novo cliente
    // Mapeia solicitações POST para "/clientes"
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente); // Retorna o cliente criado com status 201
    }

    // Edit: Atualiza um cliente existente
    // Mapeia solicitações PUT para "/clientes/{codigo}"
    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int codigo, @RequestBody Cliente cliente) {
        if (!clienteService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        Cliente updatedCliente = clienteService.edit(codigo, cliente);
        return ResponseEntity.ok(updatedCliente); // Retorna o cliente atualizado com status 200
    }

    // Delete: Remove um cliente pelo código
    // Mapeia solicitações DELETE para "/clientes/{codigo}"
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int codigo) {
        if (!clienteService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        clienteService.delete(codigo);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }
}
