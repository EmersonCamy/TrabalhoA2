package com.a2.modelo;

import jakarta.persistence.*;

/**
 * Entidade que representa um Produto no sistema.
 */
@Entity
@Table(name = "Produto") // Especifica o nome da tabela
public class Produto {

    @Id
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