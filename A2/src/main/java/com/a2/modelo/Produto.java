package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

/**
 * Entidade que representa um Produto no sistema.
 */
@Entity
@Table(name = "Produto") // Define que esta classe será mapeada para uma tabela chamada "Produto" no banco de dados.
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo"
) // Define "codigo" como identificador único na serialização JSON para evitar problemas de referência cíclica.
public class Produto {

    @Id
    private int codigo; // Define "codigo" como a chave primária da entidade Produto.

    private String nome;
    private String descricao;
    private double preco;

    // Relação One-to-One com ItemPedido
    @OneToOne(mappedBy = "produto") // Define uma relação de um para um com a entidade ItemPedido.
    // "mappedBy = 'produto'" indica que o campo "produto" em ItemPedido é o dono da relação.
    private ItemPedido itemPedido;

    // Construtor padrão
    public Produto() {
    }

    // Construtor com parâmetros para inicializar os campos da classe
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

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }
}
