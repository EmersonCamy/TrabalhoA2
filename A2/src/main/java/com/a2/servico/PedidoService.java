package com.a2.servico;

import com.a2.modelo.ItemPedido;
import com.a2.modelo.Pedido;
import com.a2.repositorio.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Browse
    @Transactional(readOnly = true)
    public List<Pedido> browse() {
        return pedidoRepository.findAll();
    }

    // Read
    @Transactional(readOnly = true)
    public Optional<Pedido> read(int codigo) {
        return pedidoRepository.findById(codigo);
    }

    // Add
    public Pedido add(Pedido pedido) {
        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }

    // Edit
    public Pedido edit(int codigo, Pedido pedido) {
        pedido.setCodigo(codigo);
        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }

    // Delete
    public void delete(int codigo) {
        pedidoRepository.deleteById(codigo);
    }
}