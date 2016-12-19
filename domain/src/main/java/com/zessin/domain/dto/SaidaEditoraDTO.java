package com.zessin.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zessin.domain.entity.Editora;

public class SaidaEditoraDTO {
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("nome")
    private String nome;
    
    public SaidaEditoraDTO() {
    
    }
    
    public SaidaEditoraDTO(Editora editora) {
        id = editora.getId();
        nome = editora.getNome();
    }

    public static List<SaidaEditoraDTO> converterEditorasEmEditorasDTO(List<Editora> editoras) {
        List<SaidaEditoraDTO> editorasDTO = new ArrayList<SaidaEditoraDTO>();
        
        for (Editora editora : editoras) {
            editorasDTO.add(new SaidaEditoraDTO(editora));
        }
        
        return editorasDTO;
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
