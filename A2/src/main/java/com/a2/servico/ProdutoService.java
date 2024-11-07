package com.a2.servico;

import com.a2.modelo.Produto;
import com.a2.repositorio.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Browse
    public List<Produto> browse() {
        return produtoRepository.findAll();
    }

    // Read
    public Optional<Produto> read(int codigo) {
        return produtoRepository.findById(codigo);
    }

    // Add
    public Produto add(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Edit
    public Produto edit(int codigo, Produto produto) {
        produto.setCodigo(codigo);
        return produtoRepository.save(produto);
    }

    // Delete
    public void delete(int codigo) {
        produtoRepository.deleteById(codigo);
    }
}
