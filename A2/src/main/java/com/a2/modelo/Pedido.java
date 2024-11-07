package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Entidade que representa um Pedido no sistema.
 *
 * Relação:
 * - Um Pedido tem muitos ItemPedido (1:N)
 * - Cada ItemPedido pertence a um Pedido
 */
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "Pedido") // Especifica o nome da tabela no banco de dados
public class Pedido {

    @Id // Indica que o campo 'codigo' é a chave primária
    private int codigo;

    private String nome;

    // Relação Muitos-para-Um com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_codigo") // Especifica a coluna de chave estrangeira para Cliente
    private Cliente cliente;

    // Relação Muitos-para-Um com Fornecedor
    @ManyToOne
    @JoinColumn(name = "fornecedor_codigo") // Especifica a coluna de chave estrangeira para Fornecedor
    private Fornecedor fornecedor;

    // Relação Um-para-Muitos com ItemPedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference // Ajuda a gerenciar referências cíclicas na serialização JSON
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

    // Método chamado antes de persistir uma nova entidade
    @PrePersist
    protected void onCreate() {
        Date currentDate = new Date();
        this.dataDeInclusao = currentDate;
        this.dataDeAlteracao = currentDate;
    }

    // Método chamado antes de atualizar uma entidade existente
    @PreUpdate
    protected void onUpdate() {
        this.dataDeAlteracao = new Date();
    }
}