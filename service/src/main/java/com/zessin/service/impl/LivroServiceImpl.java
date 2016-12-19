package com.zessin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zessin.business.LivroBusiness;
import com.zessin.domain.dto.EntradaLivroDTO;
import com.zessin.domain.dto.SaidaLivroDTO;
import com.zessin.service.LivroService;

@Component
public class LivroServiceImpl implements LivroService {
    
    @Autowired
    private LivroBusiness livroBusiness;

    @Override
    public void cadastrar(EntradaLivroDTO livro) throws Exception {
        livroBusiness.salvar(livro);
    }

    @Override
    public void alterar(Long id, EntradaLivroDTO livro) throws Exception {
        livroBusiness.alterar(id, livro);
    }

    @Override
    public List<SaidaLivroDTO> listar() {
        return livroBusiness.buscarTodos();
    }

    @Override
    public SaidaLivroDTO listarPorId(Long id) throws Exception {
        return livroBusiness.buscarPorId(id);
    }

    @Override
    public List<SaidaLivroDTO> listarPorNome(String nome) {
        return livroBusiness.buscarPorNome(nome);
    }

    @Override
    public void remover(Long id) {
        livroBusiness.remover(id);
    }

}
