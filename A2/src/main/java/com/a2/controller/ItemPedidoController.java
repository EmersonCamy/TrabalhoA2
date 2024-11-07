package com.a2.controller;

import com.a2.modelo.ItemPedido;
import com.a2.servico.ItemPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itenspedido")
public class ItemPedidoController {
    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    // Browse
    @GetMapping
    public ResponseEntity<List<ItemPedido>> getAllItemPedidos() {
        List<ItemPedido> itens = itemPedidoService.browse();
        return ResponseEntity.ok(itens);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> getItemPedidoById(@PathVariable int id) {
        Optional<ItemPedido> itemPedido = itemPedidoService.read(id);
        return itemPedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add
    @PostMapping
    public ResponseEntity<ItemPedido> createItemPedido(@RequestBody ItemPedido itemPedido) {
        ItemPedido createdItemPedido = itemPedidoService.add(itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItemPedido);
    }

    // Edit
    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> updateItemPedido(@PathVariable int id, @RequestBody ItemPedido itemPedido) {
        if (!itemPedidoService.read(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ItemPedido updatedItemPedido = itemPedidoService.edit(id, itemPedido);
        return ResponseEntity.ok(updatedItemPedido);
    }
    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable int id) {
        if (!itemPedidoService.read(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemPedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
