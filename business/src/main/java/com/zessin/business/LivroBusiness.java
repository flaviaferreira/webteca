package com.zessin.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.zessin.domain.dto.EntradaLivroDTO;
import com.zessin.domain.dto.SaidaLivroDTO;
import com.zessin.domain.entity.Autor;
import com.zessin.domain.entity.Editora;
import com.zessin.domain.entity.Livro;
import com.zessin.domain.repository.AutorRepository;
import com.zessin.domain.repository.EditoraRepository;
import com.zessin.domain.repository.LivroRepository;

@Component
public class LivroBusiness {
    
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private AutorRepository autorRepository;

    public void salvar(EntradaLivroDTO livroDto) throws Exception {
        Livro livro = new Livro();
        
        salvarLivro(livroDto, livro);
    }
    
    public void alterar(Long id, EntradaLivroDTO livroDto) throws Exception {
        Livro livro = livroRepository.findOne(id);
        
        if (livro == null) {
            throw new Exception("Livro não encontrado para o id " + id + "!");
        }
        
        salvarLivro(livroDto, livro);
    }

    public List<SaidaLivroDTO> buscarTodos() {
        List<Livro> livros = livroRepository.findAll();
        return SaidaLivroDTO.converteLivrosEmLivrosDTO(livros);
    }

    public SaidaLivroDTO buscarPorId(Long id) throws Exception {
        Livro livro = livroRepository.findOne(id);
        
        if (livro == null) {
            throw new Exception("Livro não encontrado para o id " + id + "!");
        }
        
        return new SaidaLivroDTO(livro);
    }

    public List<SaidaLivroDTO> buscarPorNome(String nome) {
        List<Livro> livros = livroRepository.findByNome(nome.toUpperCase());
        return SaidaLivroDTO.converteLivrosEmLivrosDTO(livros);
    }
    
    public void remover(Long id) {
        livroRepository.delete(id);
    }

    private void salvarLivro(EntradaLivroDTO livroDto, Livro livro) throws Exception {
        List<Autor> autores = autorRepository.findAll(livroDto.getIdAutores());
        
        Editora editora = editoraRepository.findOne(livroDto.getIdEditora());
        
        if (CollectionUtils.isEmpty(autores)) {
            throw new Exception("Autor(es) não encontrado(s) para o(s) id(s) " + livroDto.getIdAutores() + "!");
        }

        if (editora == null) {
            throw new Exception("Editora não encontrada para o id " + livroDto.getIdEditora() + "!");
        }
        
        livro.setNome(livroDto.getNome());
        livro.setCategoria(livroDto.getCategoria());
        livro.setDataPublicacao(livroDto.getDataPublicacao());
        livro.setQuantidadePaginas(livroDto.getQuantidadePaginas());
        livro.setAutores(autores);
        livro.setEditora(editora);

        livroRepository.save(livro);
    }
    
}
