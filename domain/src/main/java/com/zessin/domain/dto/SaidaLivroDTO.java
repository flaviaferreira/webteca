package com.zessin.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zessin.domain.entity.Autor;
import com.zessin.domain.entity.Categoria;
import com.zessin.domain.entity.Livro;

public class SaidaLivroDTO {
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("categoria")
    private Categoria categoria;
    
    @JsonProperty("dataPublicacao")
    private Date dataPublicacao;
    
    @JsonProperty("quantidadePaginas")
    private Integer quantidadePaginas;
    
    @JsonProperty("nomeEditora")
    private String nomeEditora;

    @JsonProperty("nomeAutores")
    private List<String> nomeAutores;
    
    public SaidaLivroDTO() {
    }

    public SaidaLivroDTO(Livro livro) {
        id = livro.getId();
        nome = livro.getNome();
        categoria = livro.getCategoria();
        dataPublicacao = livro.getDataPublicacao();
        quantidadePaginas = livro.getQuantidadePaginas();
        nomeEditora = livro.getEditora().getNome();

        nomeAutores = new ArrayList<String>();

        for (Autor autor : livro.getAutores()) {
            nomeAutores.add(autor.getNome());
        }

    }
    
    public static List<SaidaLivroDTO> converteLivrosEmLivrosDTO(List<Livro> livros) {
        List<SaidaLivroDTO> livrosDTO = new ArrayList<SaidaLivroDTO>();
        
        for (Livro livro : livros) {
            livrosDTO.add(new SaidaLivroDTO(livro));
        }
        
        return livrosDTO;
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

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public List<String> getNomeAutores() {
        return nomeAutores;
    }

    public void setNomeAutores(List<String> nomeAutores) {
        this.nomeAutores = nomeAutores;
    }
    
}
