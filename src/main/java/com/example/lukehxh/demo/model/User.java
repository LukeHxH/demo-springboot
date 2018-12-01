package com.example.lukehxh.demo.model;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

    private String name;
    private String cpf;

    public User() {}

    public User(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}