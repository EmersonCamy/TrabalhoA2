package com.a2.servico;

import com.a2.modelo.Cliente;
import com.a2.repositorio.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Browse: Retorna todos os clientes
    public List<Cliente> browse() {
        return clienteRepository.findAll();
    }

    // Read: Busca um cliente específico pelo código
    public Optional<Cliente> read(int codigo) {
        return clienteRepository.findById(codigo);
    }

    // Edit: Atualiza um cliente existente
    public Cliente edit(int codigo, Cliente cliente) {
        cliente.setCodigo(codigo); // Garante que o código é o mesmo
        return clienteRepository.save(cliente);
    }

    // Add: Adiciona um novo cliente
    public Cliente add(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Delete: Remove um cliente pelo código
    public void delete(int codigo) {
        clienteRepository.deleteById(codigo);
    }
}
