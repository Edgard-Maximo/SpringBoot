package br.org.LojaDeGames.minhaLojaDeGames.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.LojaDeGames.minhaLojaDeGames.model.Usuario;
import br.org.LojaDeGames.minhaLojaDeGames.model.UsuarioLogin;
import br.org.LojaDeGames.minhaLojaDeGames.repository.UsuarioRepository;
import br.org.LojaDeGames.minhaLojaDeGames.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	 @Autowired
	 private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;
	
	

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> GetAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> AutenticationUser(@RequestBody Optional<UsuarioLogin> user) {
		
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());

	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		
		Usuario usuarioResp = usuarioService.CadastrarUsuario(usuario);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResp);

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
		

	@PutMapping("/alterar")
	public ResponseEntity<Usuario> alterar (@RequestBody Usuario usuario) {
		Optional<Usuario> updateUsuario = usuarioService.atualizar(usuario);
		try {
			return ResponseEntity.ok(updateUsuario.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	}


