package com.a2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidade que representa um Cliente no sistema.
 */
@Entity
@Table(name = "Cliente") // Especifica o nome da tabela
public class Cliente {

    @Id
    private int codigo;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    // Construtor padrão
    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(int codigo, String telefone, String nome, String cpf, String email) {
        this.codigo = codigo;
        this.telefone = telefone;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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