package dev.fujioka.java.avancado.web.repository;

import java.util.List;

import dev.fujioka.java.avancado.web.domain.Livro;

public interface LivroRepositoryCustom {

	public List<Livro> buscaAvancada(String titulo, Integer ano, String autor, String editora);
	
}
