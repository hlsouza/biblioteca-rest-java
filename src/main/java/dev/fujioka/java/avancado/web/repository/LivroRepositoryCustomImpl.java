package dev.fujioka.java.avancado.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.fujioka.java.avancado.web.domain.Livro;

public class LivroRepositoryCustomImpl implements LivroRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Livro> buscaAvancada(String titulo, Integer ano, String autor, String editora) {
		String jpql = "SELECT l FROM Livro l WHERE ";

		//if (!titulo.equals(""))
		if (titulo != null)
			jpql += "LOWER(l.titulo) LIKE LOWER(\'%" + titulo + "%\') AND ";
		if (ano != null)
			jpql += "l.ano = " + ano + " AND ";
		if (autor != null)
			jpql += "LOWER(l.autor) LIKE LOWER(\'%" + autor + "%\') AND ";
		if (editora != null)
			jpql += "LOWER(l.editora) LIKE LOWER(\'%" + editora + "%\') AND ";
		jpql += "1 = 1 ";
		jpql += "ORDER BY l.id DESC";

		TypedQuery<Livro> query = entityManager.createQuery(jpql, Livro.class);
		return query.getResultList();
	}
	
}
