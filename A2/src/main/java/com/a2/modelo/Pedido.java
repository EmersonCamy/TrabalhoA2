package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Entidade que representa um Pedido no sistema.
 *
 * Relação:
 * - Um Pedido possui muitos ItemPedido (1:N)
 */
@Entity
@Table(name = "Pedido") // Define que esta classe será mapeada para uma tabela no banco de dados chamada "Pedido".
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo"
) // Usa "codigo" como identificador único para evitar problemas de referência cíclica durante a serialização JSON.
public class Pedido {

    @Id
    private int codigo; // Define "codigo" como a chave primária da entidade.

    private String nome;

    // Relação Muitos-para-Um com Cliente
    @ManyToOne // Define que muitos pedidos podem estar associados a um único cliente.
    @JoinColumn(name = "cliente_codigo") // Define a coluna "cliente_codigo" como chave estrangeira que aponta para o cliente.
    private Cliente cliente;

    // Relação Muitos-para-Um com Fornecedor
    @ManyToOne // Define que muitos pedidos podem estar associados a um único fornecedor.
    @JoinColumn(name = "fornecedor_codigo") // Define a coluna "fornecedor_codigo" como chave estrangeira que aponta para o fornecedor.
    private Fornecedor fornecedor;

    // Relação Um-para-Muitos com ItemPedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference // Garante que o lado "dono" da relação seja serializado, evitando referências cíclicas.
    private Set<ItemPedido> itens;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_inclusao") // Define o mapeamento da data de inclusão como uma coluna chamada "data_de_inclusao".
    private Date dataDeInclusao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_alteracao") // Define o mapeamento da data de alteração como uma coluna chamada "data_de_alteracao".
    private Date dataDeAlteracao;

    // Construtor padrão
    public Pedido() {
    }

    // Construtor com parâmetros para inicializar os campos
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

    // Métodos de Callback para persistência

    @PrePersist // Método chamado automaticamente antes de o objeto ser salvo pela primeira vez. Define as datas iniciais.
    protected void onCreate() {
        Date currentDate = new Date();
        this.dataDeInclusao = currentDate;
        this.dataDeAlteracao = currentDate;
    }

    @PreUpdate // Método chamado automaticamente antes de o objeto ser atualizado. Define a data de alteração.
    protected void onUpdate() {
        this.dataDeAlteracao = new Date();
    }
}
