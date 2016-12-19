package com.zessin.service;

import java.util.List;

import com.zessin.domain.dto.EntradaLivroDTO;
import com.zessin.domain.dto.SaidaLivroDTO;

public interface LivroService {

    void cadastrar(EntradaLivroDTO livro) throws Exception;

    void alterar(Long id, EntradaLivroDTO livro) throws Exception;

    List<SaidaLivroDTO> listar();

    SaidaLivroDTO listarPorId(Long id) throws Exception;

    List<SaidaLivroDTO> listarPorNome(String nome);

    void remover(Long id);

}
