package com.a2.controller;

import com.a2.modelo.Pedido;
import com.a2.servico.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Indicar que esta classe é um controlador REST
@RestController
// Define a rota base para este controlador
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Browse: Retorna todos os pedidos
    // Mapeia solicitações GET para "/pedidos"
    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.browse();
        return ResponseEntity.ok(pedidos); // Retorna a lista de pedidos com status 200 OK
    }

    // Read: Busca um pedido específico pelo código
    // Mapeia solicitações GET para "/pedidos/{codigo}"
    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int codigo) {
        Optional<Pedido> pedido = pedidoService.read(codigo);
        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrado
    }

    // Add: Adiciona um novo pedido
    // Mapeia solicitações POST para "/pedidos"
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido createdPedido = pedidoService.add(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido); // Retorna o pedido criado com status 201
    }

    // Edit: Atualiza um pedido existente
    // Mapeia solicitações PUT para "/pedidos/{codigo}"
    @PutMapping("/{codigo}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable int codigo, @RequestBody Pedido pedido) {
        if (!pedidoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        Pedido updatedPedido = pedidoService.edit(codigo, pedido);
        return ResponseEntity.ok(updatedPedido); // Retorna o pedido atualizado com status 200
    }

    // Delete: Remove um pedido pelo código
    // Mapeia solicitações DELETE para "/pedidos/{codigo}"
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletePedido(@PathVariable int codigo) {
        if (!pedidoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        pedidoService.delete(codigo);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }
}
