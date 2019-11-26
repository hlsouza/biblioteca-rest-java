package dev.fujioka.java.avancado.web.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.java.avancado.web.domain.Livro;
import dev.fujioka.java.avancado.web.service.LivroService;

@RestController
@RequestMapping("/api")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping("/livro")
	public List<Livro> getAll() {
		return livroService.findAll();
	}

	@GetMapping("/livro/{id}")
	public ResponseEntity<Livro> getById(@PathVariable Long id) {
		Optional<Livro> retorno = livroService.findById(id);

		if (retorno.isPresent())
			return ResponseEntity.of(retorno);

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/livroBuscaAvancada")
	public List<Livro> buscaAvancada(@RequestParam(value = "titulo", required = false) String titulo,
			@RequestParam(value = "ano", required = false) Integer ano,
			@RequestParam(value = "autor", required = false) String autor,
			@RequestParam(value = "editora", required = false) String editora) {
		
		List<Livro> retorno = livroService.buscaAvancada(titulo, ano, autor, editora);

		if (retorno != null)
			return retorno;

		return null;
	}

	@PostMapping("/livro")
	public ResponseEntity<Livro> save(@Valid @RequestBody Livro livro) {
		livroService.save(livro);
		return ResponseEntity.ok(livro);
	}

	@DeleteMapping("/livro/{id}")
	public ResponseEntity<Livro> removeById(@PathVariable Long id) {
		livroService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/livro")
	public ResponseEntity<Livro> remove(@Valid @RequestBody Livro livro) {
		livroService.delete(livro);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/livro/{id}")
	public ResponseEntity<Livro> updateById(@Valid @RequestBody Livro livro, @PathVariable long id) {
		Optional<Livro> retorno = livroService.findById(id);
		Livro livroAtualizado = retorno.get();
		if (livroAtualizado != null) {
			livroAtualizado.setAno(livro.getAno());
			livroAtualizado.setAutor(livro.getAutor());
			livroAtualizado.setEditora(livro.getEditora());
			livroAtualizado.setTitulo(livro.getTitulo());
			if (livroService.save(livroAtualizado).get().getId().equals(id))
				return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
