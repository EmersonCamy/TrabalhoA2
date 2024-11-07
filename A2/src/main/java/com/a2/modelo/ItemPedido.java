package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Entidade que representa um Item de Pedido, relacionando um Produto a um Pedido.
 */
@Entity
@Table(name = "ItemPedido") // Especifica o nome da tabela
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Mapeia o relacionamento com Pedido usando a coluna 'pedido_codigo'
    @ManyToOne
    @JoinColumn(name = "pedido_codigo")
    @JsonBackReference
    private Pedido pedido;

    // Mapeia o relacionamento com Produto usando a coluna 'produto_codigo'
    @ManyToOne
    @JoinColumn(name = "produto_codigo")
    private Produto produto;

    private int quantidade;
    private double precoUnitario;

    // Construtor padrão
    public ItemPedido() {
    }

    // Construtor com parâmetros
    public ItemPedido(Pedido pedido, Produto produto, int quantidade, double precoUnitario) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}