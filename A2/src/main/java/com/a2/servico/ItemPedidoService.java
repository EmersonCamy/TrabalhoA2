package com.a2.servico;

import com.a2.modelo.ItemPedido;
import com.a2.repositorio.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Serviço para operações relacionadas a ItemPedido.
 */
@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    // Browse: Retorna todos os itens de pedido
    public List<ItemPedido> browse() {
        return itemPedidoRepository.findAll();
    }

    // Read: Busca um item de pedido específico pelo ID
    public Optional<ItemPedido> read(int id) {
        return itemPedidoRepository.findById(id);
    }

    // Add: Adiciona um novo item de pedido
    public ItemPedido add(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    // Edit: Atualiza um item de pedido existente
    public ItemPedido edit(int id, ItemPedido itemPedido) {
        // Recupera o ItemPedido existente do banco de dados
        Optional<ItemPedido> existingItem = itemPedidoRepository.findById(id);
        if (!existingItem.isPresent()) {
            throw new EntityNotFoundException("ItemPedido não encontrado com o ID " + id);
        }

        ItemPedido itemToUpdate = existingItem.get();

        // Atualiza os campos necessários
        itemToUpdate.setPedido(itemPedido.getPedido());
        itemToUpdate.setProduto(itemPedido.getProduto());
        itemToUpdate.setQuantidade(itemPedido.getQuantidade());
        itemToUpdate.setPrecoUnitario(itemPedido.getPrecoUnitario());

        // Salva o ItemPedido atualizado
        return itemPedidoRepository.save(itemToUpdate);
    }

    // Delete: Remove um item de pedido pelo ID
    public void delete(int id) {
        itemPedidoRepository.deleteById(id);
    }
}
