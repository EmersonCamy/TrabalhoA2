package com.a2.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidade que representa um Fornecedor no sistema.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "Fornecedor") // Especifica o nome da tabela no banco de dados
public class Fornecedor {

    @Id // Indica que o campo 'codigo' é a chave primária
    private int codigo;

    @Column(name = "razao_social") // Mapeia o campo para a coluna 'razao_social' no banco
    private String razaoSocial;

    @Column(name = "nome_fantasia") // Mapeia o campo para a coluna 'nome_fantasia' no banco
    private String nomeFantasia;

    private String cnpj;
    private String email;
    private String telefone;

    // Construtor padrão
    public Fornecedor() {
    }

    // Construtor com parâmetros
    public Fornecedor(int codigo, String telefone, String cnpj, String email, String nomeFantasia, String razaoSocial) {
        this.codigo = codigo;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.email = email;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }

    // Getters e Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
