package com.zessin.service;

import java.util.List;

import com.zessin.domain.dto.EntradaAutorDTO;
import com.zessin.domain.dto.SaidaAutorDTO;
import com.zessin.domain.dto.SaidaLivroDTO;

public interface AutorService {

    void cadastrar(EntradaAutorDTO autor);

    void alterar(Long id, EntradaAutorDTO autor) throws Exception;

    List<SaidaAutorDTO> listar();

    SaidaAutorDTO listarPorId(Long id) throws Exception;

    List<SaidaAutorDTO> listarPorNome(String nome);

    List<SaidaLivroDTO> listarLivros(Long idAutor) throws Exception;

    void remover(Long id);

}
