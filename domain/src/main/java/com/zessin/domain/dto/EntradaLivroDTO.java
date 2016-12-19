package com.zessin.domain.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zessin.domain.entity.Categoria;

public class EntradaLivroDTO {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("categoria")
    private Categoria categoria;
    
    @JsonProperty("dataPublicacao")
    private Date dataPublicacao;
    
    @JsonProperty("quantidadePaginas")
    private Integer quantidadePaginas;
    
    @JsonProperty("idEditora")
    private Long idEditora;
    
    @JsonProperty("idAutores")
    private List<Long> idAutores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }

    public List<Long> getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(List<Long> idAutores) {
        this.idAutores = idAutores;
    }

}
