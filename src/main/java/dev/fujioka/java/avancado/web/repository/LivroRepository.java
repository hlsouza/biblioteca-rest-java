package dev.fujioka.java.avancado.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.java.avancado.web.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>, LivroRepositoryCustom {

	public List<Livro> findByTitulo(String titulo);
	
	public List<Livro> findByAno(int ano);
	
	public List<Livro> findByAutor(String autor);
	
	public List<Livro> findByEditora(String editora);
	
	//tem que especificar a query porque mudou o padrao do nome do metodo (em ingles)
	//@Query("Select a from Avaliacao a where a.professor = :titulo")
	//public List<Livro> buscaPorTitulo(@Param("titulo") String titulo);
}
