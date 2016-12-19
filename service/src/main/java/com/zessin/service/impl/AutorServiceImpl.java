package com.zessin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zessin.business.AutorBusiness;
import com.zessin.domain.dto.EntradaAutorDTO;
import com.zessin.domain.dto.SaidaAutorDTO;
import com.zessin.domain.dto.SaidaLivroDTO;
import com.zessin.service.AutorService;

@Component
public class AutorServiceImpl implements AutorService {
    
    @Autowired
    AutorBusiness autorBusiness;

    @Override
    public void cadastrar(EntradaAutorDTO autor) {
        autorBusiness.cadastrar(autor);
    }

    @Override
    public void alterar(Long id, EntradaAutorDTO autor) throws Exception {
        autorBusiness.alterar(id, autor);
    }

    @Override
    public List<SaidaAutorDTO> listar() {
        return autorBusiness.listar();
    }

    @Override
    public SaidaAutorDTO listarPorId(Long id) throws Exception {
        return autorBusiness.listarPorId(id);
    }

    @Override
    public List<SaidaAutorDTO> listarPorNome(String nome) {
        return autorBusiness.listarPorNome(nome);
    }

    @Override
    public List<SaidaLivroDTO> listarLivros(Long idAutor) throws Exception {
        return autorBusiness.listarLivros(idAutor);
    }

    @Override
    public void remover(Long id) {
        autorBusiness.remover(id);
    }

}
