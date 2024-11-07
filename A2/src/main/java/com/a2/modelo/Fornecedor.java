package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

/**
 * Entidade que representa um Fornecedor no sistema.
 */
@Entity
@Table(name = "Fornecedor") // Define que esta classe será mapeada para uma tabela chamada "Fornecedor" no banco de dados.
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo"
) // Configura "codigo" como identificador único para evitar problemas de referência circular na serialização JSON.
public class Fornecedor {

    @Id // Define "codigo" como a chave primária da entidade Fornecedor.
    private int codigo;

    @Column(name = "razao_social") // Mapeia o campo "razaoSocial" para a coluna "razao_social" na tabela.
    private String razaoSocial;

    @Column(name = "nome_fantasia") // Mapeia o campo "nomeFantasia" para a coluna "nome_fantasia" na tabela.
    private String nomeFantasia;

    private String cnpj;
    private String email;
    private String telefone;

    // Construtor padrão
    public Fornecedor() {
    }

    // Construtor com parâmetros para inicializar os campos da classe
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
