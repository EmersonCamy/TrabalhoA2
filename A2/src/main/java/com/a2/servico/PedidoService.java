package com.a2.servico;

import com.a2.modelo.ItemPedido;
import com.a2.modelo.Pedido;
import com.a2.repositorio.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um serviço do Spring
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    // Injeta o repositório de Pedido
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Browse: Retorna todos os pedidos
    @Transactional(readOnly = true)
    public List<Pedido> browse() {
        return pedidoRepository.findAll();
    }

    // Read: Busca um pedido específico pelo código
    @Transactional(readOnly = true)
    public Optional<Pedido> read(int codigo) {
        return pedidoRepository.findById(codigo);
    }

    // Add: Adiciona um novo pedido
    public Pedido add(Pedido pedido) {
        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido); // Define o pedido em cada item
            }
        }
        return pedidoRepository.save(pedido);
    }

    // Edit: Atualiza um pedido existente
    public Pedido edit(int codigo, Pedido pedido) {
        pedido.setCodigo(codigo); // Garante que o código permanece o mesmo
        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido); // Define o pedido em cada item
            }
        }
        return pedidoRepository.save(pedido);
    }

    // Delete: Remove um pedido pelo código
    public void delete(int codigo) {
        pedidoRepository.deleteById(codigo);
    }
}
