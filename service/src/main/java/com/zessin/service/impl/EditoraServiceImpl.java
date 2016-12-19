package com.zessin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zessin.business.EditoraBusiness;
import com.zessin.domain.dto.EntradaEditoraDTO;
import com.zessin.domain.dto.SaidaEditoraDTO;
import com.zessin.service.EditoraService;

@Component
public class EditoraServiceImpl implements EditoraService {
    
    @Autowired
    EditoraBusiness editoraBusiness;

    @Override
    public void cadastrar(EntradaEditoraDTO editora) {
        editoraBusiness.cadastrar(editora);
    }

    @Override
    public void alterar(Long id, EntradaEditoraDTO editora) throws Exception {
        editoraBusiness.alterar(id, editora);
    }

    @Override
    public List<SaidaEditoraDTO> listar() {
        return editoraBusiness.listar();
    }

    @Override
    public SaidaEditoraDTO listarPorId(Long id) throws Exception {
        return editoraBusiness.listarPorId(id);
    }

    @Override
    public List<SaidaEditoraDTO> listarPorNome(String nome) {
        return editoraBusiness.listarPorNome(nome);
    }

    @Override
    public void remover(Long id) {
        editoraBusiness.remover(id);
    }

}
