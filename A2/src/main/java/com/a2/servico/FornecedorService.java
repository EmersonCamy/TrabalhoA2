package com.a2.servico;

import com.a2.modelo.Fornecedor;
import com.a2.repositorio.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    // Browse: Retorna todos os fornecedores
    public List<Fornecedor> browse() {
        return fornecedorRepository.findAll();
    }

    // Read: Busca um fornecedor específico pelo código
    public Optional<Fornecedor> read(int codigo) {
        return fornecedorRepository.findById(codigo);
    }

    // Edit: Atualiza um fornecedor existente
    public Fornecedor edit(int codigo, Fornecedor fornecedor) {
        fornecedor.setCodigo(codigo); // Garante que o código é o mesmo
        return fornecedorRepository.save(fornecedor);
    }

    // Add: Adiciona um novo fornecedor
    public Fornecedor add(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // Delete: Remove um fornecedor pelo código
    public void delete(int codigo) {
        fornecedorRepository.deleteById(codigo);
    }
}