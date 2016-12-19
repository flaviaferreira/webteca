package com.zessin.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zessin.domain.entity.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    
    @Query("select e from Editora e where upper(e.nome) like %:nome%")
    List<Editora> findByNome(@Param("nome")String nome);

}
