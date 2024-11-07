package com.a2.controller;

import com.a2.modelo.ItemPedido;
import com.a2.servico.ItemPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um controlador REST
@RestController
// Define a rota base para este controlador
@RequestMapping("/itenspedido")
public class ItemPedidoController {

    // Injeta o serviço de ItemPedido
    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    // Browse: Retorna todos os itens de pedido
    // Mapeia solicitações GET para "/itenspedido"
    @GetMapping
    public ResponseEntity<List<ItemPedido>> getAllItemPedidos() {
        List<ItemPedido> itens = itemPedidoService.browse();
        return ResponseEntity.ok(itens); // Retorna a lista de itens de pedido com status 200 OK
    }

    // Read: Busca um item de pedido específico pelo ID
    // Mapeia solicitações GET para "/itenspedido/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> getItemPedidoById(@PathVariable int id) {
        Optional<ItemPedido> itemPedido = itemPedidoService.read(id);
        return itemPedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se não encontrado
    }

    // Add: Adiciona um novo item de pedido
    // Mapeia solicitações POST para "/itenspedido"
    @PostMapping
    public ResponseEntity<ItemPedido> createItemPedido(@RequestBody ItemPedido itemPedido) {
        ItemPedido createdItemPedido = itemPedidoService.add(itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItemPedido); // Retorna o item criado com status 201
    }

    // Edit: Atualiza um item de pedido existente
    // Mapeia solicitações PUT para "/itenspedido/{id}"
    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> updateItemPedido(@PathVariable int id, @RequestBody ItemPedido itemPedido) {
        if (!itemPedidoService.read(id).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        ItemPedido updatedItemPedido = itemPedidoService.edit(id, itemPedido);
        return ResponseEntity.ok(updatedItemPedido); // Retorna o item atualizado com status 200
    }

    // Delete: Remove um item de pedido pelo ID
    // Mapeia solicitações DELETE para "/itenspedido/{id}"
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable int id) {
        if (!itemPedidoService.read(id).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrado
        }
        itemPedidoService.delete(id);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }
}