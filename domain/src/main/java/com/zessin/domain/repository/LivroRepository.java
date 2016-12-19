package com.zessin.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zessin.domain.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
    @Query("select l from Livro l where upper(l.nome) like %:nome%")
    List<Livro> findByNome(@Param("nome") String nome);

}
