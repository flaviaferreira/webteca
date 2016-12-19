package com.zessin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zessin.domain.dto.EntradaAutorDTO;
import com.zessin.domain.dto.SaidaAutorDTO;
import com.zessin.domain.dto.SaidaLivroDTO;
import com.zessin.service.AutorService;

@RestController
public class AutorController {
    
    @Autowired
    AutorService autorService;
    
    @RequestMapping(path = "/v1/autores", method = RequestMethod.POST)
    public void cadastrar(@RequestBody EntradaAutorDTO autor) {
        autorService.cadastrar(autor);
    }
    
    @RequestMapping(path = "/v1/autores/{id}/alterar", method = RequestMethod.POST)
    public void alterar(@PathVariable Long id, @RequestBody EntradaAutorDTO autor) throws Exception {
        autorService.alterar(id, autor);
    }
    
    @RequestMapping(path = "/v1/autores/listar", method = RequestMethod.GET)
    public List<SaidaAutorDTO> listar() {
        return autorService.listar();
    }
    
    @RequestMapping(path = "/v1/autores/{id}", method = RequestMethod.GET)
    public SaidaAutorDTO listarPorId(@PathVariable Long id) throws Exception {
        return autorService.listarPorId(id);
    }
    
    @RequestMapping(path = "/v1/autores/listar-por-nome/{nome}", method = RequestMethod.GET)
    public List<SaidaAutorDTO> listarPorNome(@PathVariable String nome) {
        return autorService.listarPorNome(nome);
    }

    @RequestMapping(path = "/v1/autores/{idAutor}/livros", method = RequestMethod.GET)
    public List<SaidaLivroDTO> listarLivros(@PathVariable Long idAutor) throws Exception {
        return autorService.listarLivros(idAutor);
    }
    
    @RequestMapping(path = "/v1/autores/{id}", method = RequestMethod.DELETE)
    public void remover(@PathVariable Long id) {
        autorService.remover(id);
    }
}
