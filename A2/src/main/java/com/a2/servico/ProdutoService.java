package com.a2.servico;

import com.a2.modelo.Produto;
import com.a2.repositorio.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um serviço do Spring
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Injeta o repositório de Produto
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Browse: Retorna todos os produtos
    public List<Produto> browse() {
        return produtoRepository.findAll();
    }

    // Read: Busca um produto específico pelo código
    public Optional<Produto> read(int codigo) {
        return produtoRepository.findById(codigo);
    }

    // Add: Adiciona um novo produto
    public Produto add(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Edit: Atualiza um produto existente
    public Produto edit(int codigo, Produto produto) {
        produto.setCodigo(codigo); // Garante que o código permanece o mesmo
        return produtoRepository.save(produto);
    }

    // Delete: Remove um produto pelo código
    public void delete(int codigo) {
        produtoRepository.deleteById(codigo);
    }
}
