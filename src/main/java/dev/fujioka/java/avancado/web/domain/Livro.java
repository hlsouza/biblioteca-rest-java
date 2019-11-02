package dev.fujioka.java.avancado.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="livro") //so poe se o nome da tabela for diferente da classe
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "TITULO é obrigatório")
	@Column(name="titulo")
	private String titulo;
	
	@NotBlank(message = "AUTOR é obrigatório")
	@Column(name="autor")
	private String autor;
	
	@NotNull(message = "ANO é obrigatório")
	@Column(name="ano")
	private Integer ano;
	
	@NotBlank(message = "EDITORA é obrigatório")
	@Column(name="editora")
	private String editora;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
}
