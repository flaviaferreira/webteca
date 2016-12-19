package com.zessin.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zessin.domain.dto.EntradaEditoraDTO;
import com.zessin.domain.dto.SaidaEditoraDTO;
import com.zessin.domain.entity.Editora;
import com.zessin.domain.repository.EditoraRepository;

@Component
public class EditoraBusiness {
    
    @Autowired
    EditoraRepository editoraRepository;

    public void cadastrar(EntradaEditoraDTO editoraDTO) {
        Editora editora = new Editora();
        
        salvarEditora(editoraDTO, editora);
    }

    public void alterar(Long id, EntradaEditoraDTO editoraDTO) throws Exception {
        Editora editora = editoraRepository.findOne(id);
        
        if(editora == null) {
            throw new Exception("Editora não encontrada para o id " + id + "!");
        }
        
        salvarEditora(editoraDTO, editora);
    }

    public List<SaidaEditoraDTO> listar() {
        List<Editora> editora = editoraRepository.findAll();
        return SaidaEditoraDTO.converterEditorasEmEditorasDTO(editora);
    }

    public SaidaEditoraDTO listarPorId(Long id) throws Exception {
        Editora editora = editoraRepository.findOne(id);
        
        if(editora == null) {
            throw new Exception("Editora não encontrada para o id " + id + "!");
        }
        
        return new SaidaEditoraDTO(editora);
    }

    public List<SaidaEditoraDTO> listarPorNome(String nome) {
        List<Editora> editoras = editoraRepository.findByNome(nome);
        return SaidaEditoraDTO.converterEditorasEmEditorasDTO(editoras);
    }

    public void remover(Long id) {
        editoraRepository.delete(id);
    }

    private void salvarEditora(EntradaEditoraDTO editoraDTO, Editora editora) {
        editora.setNome(editoraDTO.getNome());
        
        editoraRepository.save(editora);
    }
}
