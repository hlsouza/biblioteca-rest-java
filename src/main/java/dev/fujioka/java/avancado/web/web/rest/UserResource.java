package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@GetMapping("/user/autentica")
	public boolean findByLoginAndPassword(@RequestParam(value = "login", required = true) String login,
			@RequestParam(value = "password", required = true) String password) {
		User retorno = userService.findByLoginAndPassword(login, password);
		if (retorno != null)
			return true;
		return false;
	}

	@PostMapping("/user")
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		userService.save(user);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/user")
	public ResponseEntity<User> update(@Valid @RequestBody User user) {
		userService.save(user);
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/user")
	public ResponseEntity<String> delete(@Valid @RequestBody User user) {
		userService.delete(user);
		return ResponseEntity.ok().body("User excluded ID: " + user.getId());
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		return ResponseEntity.ok().body("User excluded ID: " + id);
	}

}
