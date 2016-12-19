package com.zessin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zessin.domain.dto.EntradaLivroDTO;
import com.zessin.domain.dto.SaidaLivroDTO;
import com.zessin.service.LivroService;

@RestController
public class LivroController {
    
    @Autowired
    private LivroService livroService;
    
    @RequestMapping(path = "/v1/livros", method = RequestMethod.POST)
    public void cadastrar(@RequestBody EntradaLivroDTO livro) throws Exception {
        livroService.cadastrar(livro);
    }
    
    @RequestMapping(path = "/v1/livros/{id}/alterar", method = RequestMethod.POST)
    public void alterar(@PathVariable Long id, @RequestBody EntradaLivroDTO livro) throws Exception {
        livroService.alterar(id, livro);
    }
    
    @RequestMapping(path = "/v1/livros/listar", method = RequestMethod.GET)
    public List<SaidaLivroDTO> listar() {
        return livroService.listar();
    }
    
    @RequestMapping(path = "/v1/livros/{id}", method = RequestMethod.GET)
    public SaidaLivroDTO listarPorId(@PathVariable Long id) throws Exception {
        return livroService.listarPorId(id);
    }

    @RequestMapping(path = "/v1/livros/listar-por-nome/{nome}", method = RequestMethod.GET)
    public List<SaidaLivroDTO> listarPorNome(@PathVariable String nome) {
        return livroService.listarPorNome(nome);
    }
    
    @RequestMapping(path = "/v1/livros/{id}", method = RequestMethod.DELETE)
    public void remover(@PathVariable Long id) {
        livroService.remover(id);
    }
    
}
