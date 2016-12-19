package com.zessin.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zessin.domain.entity.Autor;

public class SaidaAutorDTO {
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("nome")
    private String nome;
    
    public SaidaAutorDTO() {
     
    }

    public SaidaAutorDTO(Autor autor) {
        id = autor.getId();
        nome = autor.getNome();
    }
    
    public static List<SaidaAutorDTO> converterAutoresEmAutoresDTO(List<Autor> autores) {
        List<SaidaAutorDTO> autoresDTO = new ArrayList<SaidaAutorDTO>();
        
        for (Autor autor : autores) {
            autoresDTO.add(new SaidaAutorDTO(autor));
        }
        
        return autoresDTO;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
