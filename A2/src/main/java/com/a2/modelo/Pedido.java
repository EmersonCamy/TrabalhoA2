package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Entidade que representa um Pedido no sistema.
 */
@Entity
@Table(name = "Pedido") // Especifica o nome da tabela
public class Pedido {

    @Id
    private int codigo;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "cliente_codigo") // Especifica a coluna de chave estrangeira
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fornecedor_codigo") // Especifica a coluna de chave estrangeira
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<ItemPedido> itens;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_inclusao")
    private Date dataDeInclusao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_alteracao")
    private Date dataDeAlteracao;

    // Construtor padrão
    public Pedido() {
    }

    // Construtor com parâmetros
    public Pedido(int codigo, String nome, Date dataDeInclusao, Date dataDeAlteracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataDeInclusao = dataDeInclusao;
        this.dataDeAlteracao = dataDeAlteracao;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public Date getDataDeInclusao() {
        return dataDeInclusao;
    }

    public void setDataDeInclusao(Date dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }

    public Date getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    public void setDataDeAlteracao(Date dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    @PrePersist
    protected void onCreate() {
        Date currentDate = new Date();
        this.dataDeInclusao = currentDate;
        this.dataDeAlteracao = currentDate;
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataDeAlteracao = new Date();
    }
}