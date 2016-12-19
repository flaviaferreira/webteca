package com.zessin.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntradaEditoraDTO {
    
    @JsonProperty("nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
