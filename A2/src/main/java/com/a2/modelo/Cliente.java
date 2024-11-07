package com.a2.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

/**
 * Entidade que representa um Cliente no sistema.
 */
@Entity
@Table(name = "Cliente") // Define que esta classe será mapeada para uma tabela chamada "Cliente" no banco de dados.
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo"
) // Utiliza "codigo" como identificador único para evitar problemas de referência circular na serialização JSON.
public class Cliente {

    @Id // Define "codigo" como a chave primária da entidade Cliente.
    private int codigo;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    // Construtor padrão
    public Cliente() {
    }

    // Construtor com parâmetros para inicializar os campos da classe
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
