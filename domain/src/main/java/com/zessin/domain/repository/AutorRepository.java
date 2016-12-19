package com.zessin.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zessin.domain.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
    @Query("select a from Autor a where upper(a.nome) like %:nome%")
    List<Autor> findByNome(@Param("nome") String nome);
    
}
