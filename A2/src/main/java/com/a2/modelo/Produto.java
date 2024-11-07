package com.a2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidade que representa um Produto no sistema.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "Produto") // Especifica o nome da tabela no banco de dados
public class Produto {

    @Id // Indica que o campo 'codigo' é a chave primária
    private int codigo;

    private String nome;
    private String descricao;
    private double preco;

    // Construtor padrão
    public Produto() {
    }

    // Construtor com parâmetros
    public Produto(int codigo, String nome, String descricao, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getters e Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}