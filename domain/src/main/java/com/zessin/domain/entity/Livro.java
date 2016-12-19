package com.zessin.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "CATEGORIA")
    private Categoria categoria;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_PUBLICACAO")
    private Date dataPublicacao;

    @Column(name = "QUANTIDADE_PAGINAS")
    private Integer quantidadePaginas;
    
    @ManyToOne
    @JoinColumn(name = "ID_EDITORA")
    private Editora editora;
   
    @ManyToMany
    @JoinTable(name = "LIVRO_AUTOR",
        joinColumns = {
                @JoinColumn(name = "ID_LIVRO")
            },
        inverseJoinColumns = {
                @JoinColumn(name = "ID_AUTOR")
            })
    private List<Autor> autores;

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

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }
    
}
