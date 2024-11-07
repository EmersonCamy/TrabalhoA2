package com.a2.controller;

import com.a2.modelo.Pedido;
import com.a2.servico.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Browse: Retorna todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.browse();
        return ResponseEntity.ok(pedidos);
    }

    // Read: Busca um pedido específico pelo código
    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int codigo) {
        Optional<Pedido> pedido = pedidoService.read(codigo);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add: Adiciona um novo pedido
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido createdPedido = pedidoService.add(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
    }

    // Edit: Atualiza um pedido existente
    @PutMapping("/{codigo}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable int codigo, @RequestBody Pedido pedido) {
        if (!pedidoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Pedido updatedPedido = pedidoService.edit(codigo, pedido);
        return ResponseEntity.ok(updatedPedido);
    }

    // Delete: Remove um pedido pelo código
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletePedido(@PathVariable int codigo) {
        if (!pedidoService.read(codigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
