package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

/**
 * Entidade que representa um Item de Pedido, relacionando um Produto a um Pedido.
 *
 * Relação:
 * - Muitos ItensPedido para um Pedido (N:1)
 * - Um ItemPedido para um Produto (1:1)
 */
@Entity
@Table(name = "ItemPedido") // Define que esta classe é uma entidade JPA e será mapeada para a tabela "ItemPedido" no banco de dados.
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
) // Utiliza uma anotação do Jackson para prevenir problemas de referência cíclica na serialização JSON, usando o "id" como identificador.
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a coluna "id" como a chave primária e especifica que seu valor será gerado automaticamente pelo banco.
    private int id;

    // Relação Muitos-para-Um com Pedido
    @ManyToOne // Define a relação de muitos para um com a entidade "Pedido", onde vários "ItemPedido" podem pertencer a um único "Pedido".
    @JoinColumn(name = "pedido_codigo") // Especifica a coluna de junção no banco de dados para armazenar a chave estrangeira referente ao "Pedido".
    @JsonBackReference // Evita referência cíclica serializando apenas o lado "dono" da relação.
    private Pedido pedido;

    // Relação Um-para-Um com Produto
    @OneToOne // Define uma relação de um para um com a entidade "Produto", onde um "ItemPedido" está associado a um único "Produto".
    @JoinColumn(name = "produto_codigo", unique = true) // Cria uma coluna para armazenar a chave estrangeira "produto_codigo" e garante que o relacionamento seja único.
    private Produto produto;

    private int quantidade; // Quantidade do produto neste item do pedido.
    private double precoUnitario; // Preço unitário do produto no contexto deste item do pedido.

    // Construtor padrão
    public ItemPedido() {
    }

    // Construtor com parâmetros para inicializar os atributos
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
