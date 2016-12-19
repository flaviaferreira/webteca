package com.zessin.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zessin.domain.dto.EntradaAutorDTO;
import com.zessin.domain.dto.SaidaAutorDTO;
import com.zessin.domain.dto.SaidaLivroDTO;
import com.zessin.domain.entity.Autor;
import com.zessin.domain.repository.AutorRepository;

@Component
public class AutorBusiness {
    
    @Autowired
    AutorRepository autorRepository;

    public void cadastrar(EntradaAutorDTO autorDTO) {
        Autor autor = new Autor();
        
        salvarAutor(autorDTO, autor);
    }

    public void alterar(Long id, EntradaAutorDTO autorDTO) throws Exception {
        Autor autor = autorRepository.findOne(id);
        
        if (autor == null) {
            throw new Exception("Autor não encontrado para o id " + id + "!");
        }
        
        salvarAutor(autorDTO, autor);
    }


    public List<SaidaAutorDTO> listar() {
        List<Autor> autores = autorRepository.findAll();
        return SaidaAutorDTO.converterAutoresEmAutoresDTO(autores);
    }

    public SaidaAutorDTO listarPorId(Long id) throws Exception {
        Autor autor = autorRepository.findOne(id);
        
        if(autor == null) {
            throw new Exception("Autor não encontrado para o id " + id + "!");
        }
        
        return new SaidaAutorDTO(autor);
    }

    public List<SaidaAutorDTO> listarPorNome(String nome) {
        List<Autor> autores = autorRepository.findByNome(nome);
        return SaidaAutorDTO.converterAutoresEmAutoresDTO(autores);
    }

    public List<SaidaLivroDTO> listarLivros(Long idAutor) throws Exception {
        Autor autor = autorRepository.findOne(idAutor);
        
        if(autor == null) {
            throw new Exception("Autor não encontrado para o id " + idAutor + "!");
        }
        
        return SaidaLivroDTO.converteLivrosEmLivrosDTO(autor.getLivros());
    }

    public void remover(Long id) {
        autorRepository.delete(id);
    }

    private void salvarAutor(EntradaAutorDTO autorDTO, Autor autor) {
        autor.setNome(autorDTO.getNome());
        
        autorRepository.save(autor);
    }

}
