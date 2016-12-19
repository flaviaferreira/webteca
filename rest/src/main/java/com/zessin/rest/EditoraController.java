package com.zessin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zessin.domain.dto.EntradaEditoraDTO;
import com.zessin.domain.dto.SaidaEditoraDTO;
import com.zessin.service.EditoraService;

@RestController
public class EditoraController {
    
    @Autowired
    EditoraService editoraService;
    
    @RequestMapping(path = "/v1/editoras", method = RequestMethod.POST)
    public void cadastrar(@RequestBody EntradaEditoraDTO editora) {
        editoraService.cadastrar(editora);
    }
    
    @RequestMapping(path = "/v1/editoras/{id}/alterar", method = RequestMethod.POST)
    public void alterar(@PathVariable Long id, @RequestBody EntradaEditoraDTO editora) throws Exception {
        editoraService.alterar(id, editora);
    }
    
    @RequestMapping(path = "/v1/editoras/listar", method = RequestMethod.GET)
    public List<SaidaEditoraDTO> listar() {
        return editoraService.listar();
    }
    
    @RequestMapping(path = "/v1/editoras/{id}", method = RequestMethod.GET)
    public SaidaEditoraDTO listarPorId(@PathVariable Long id) throws Exception {
        return editoraService.listarPorId(id);
    }
    
    @RequestMapping(path = "/v1/editoras/listar-por-nome/{nome}", method = RequestMethod.GET)
    public List<SaidaEditoraDTO> listarPorNome(@PathVariable String nome) {
        return editoraService.listarPorNome(nome);
    }
    
    @RequestMapping(path = "/v1/editoras/{id}", method = RequestMethod.DELETE)
    public void remover(@PathVariable Long id){
        editoraService.remover(id);
    }

}
