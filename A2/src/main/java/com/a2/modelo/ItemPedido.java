package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Entidade que representa um Item de Pedido, relacionando um Produto a um Pedido.
 *
 * Relação:
 * - Muitos ItensPedido para um Pedido (N:1)
 * - Um ItemPedido para um Produto (1:1)
 */
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "ItemPedido") // Especifica o nome da tabela no banco de dados
public class ItemPedido {

    @Id // Indica que o campo 'id' é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o valor é gerado automaticamente
    private int id;

    // Relação Muitos-para-Um com Pedido
    @ManyToOne
    @JoinColumn(name = "pedido_codigo") // Especifica a coluna de chave estrangeira para Pedido
    @JsonBackReference // Evita referência cíclica na serialização JSON
    private Pedido pedido;

    // Relação Muitos-para-Um com Produto
    @ManyToOne
    @JoinColumn(name = "produto_codigo") // Especifica a coluna de chave estrangeira para Produto
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