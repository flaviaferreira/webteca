package com.zessin.service;

import java.util.List;

import com.zessin.domain.dto.EntradaEditoraDTO;
import com.zessin.domain.dto.SaidaEditoraDTO;

public interface EditoraService {

    void cadastrar(EntradaEditoraDTO editora);

    void alterar(Long id, EntradaEditoraDTO editora) throws Exception;

    List<SaidaEditoraDTO> listar();
    
    SaidaEditoraDTO listarPorId(Long id) throws Exception;

    List<SaidaEditoraDTO> listarPorNome(String nome);

    void remover(Long id);

}
