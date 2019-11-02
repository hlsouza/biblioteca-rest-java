package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Livro;
import dev.fujioka.java.avancado.web.repository.LivroRepository;

@Service
public class LivroService implements CrudInterface<Livro> {

	@Autowired
	private LivroRepository livroRepository;
	
	@Override
	public List<Livro> findAll() {
		return livroRepository.findAll();
	}

	@Override
	public Optional<Livro> save(Livro entity) {
		return Optional.ofNullable(livroRepository.save(entity));
	}

	@Override
	public Optional<Livro> findById(long id) {
		return livroRepository.findById(id);
	}
	
	public List<Livro> findByTitulo(String titulo) {
		return livroRepository.findByTitulo(titulo);
	}

	public List<Livro> buscaAvancada(String titulo, Integer ano, String autor, String editora) {
		return livroRepository.buscaAvancada(titulo, ano, autor, editora);
	}

	@Override
	public void delete(Livro entity) {
		livroRepository.delete(entity);		
	}

	@Override
	public void deleteById(long id) {
		livroRepository.deleteById(id);
	}

	@Override
	public long count() {
		return livroRepository.count();
	}

}