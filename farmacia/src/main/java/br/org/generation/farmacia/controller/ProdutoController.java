package br.org.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.farmacia.model.ProdutoModel;
import br.org.generation.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produto_repository;

	@GetMapping
	public HttpEntity<List<ProdutoModel>> GetAll() {
		return ResponseEntity.ok(produto_repository.findAll()); // OK = 200 }
	} // Aqui é onde de fato define o método que foi assinado lá no repositório.

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable long id) {
		return produto_repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/produto/{produto}")
	public ResponseEntity<List<ProdutoModel>> Get(@PathVariable String produto) {
		return ResponseEntity.ok(produto_repository.findAllByProdutoContainingIgnoreCase(produto));

	}

	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produto_repository.save(produto));

	}

	@PutMapping
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produto_repository.save(produto));

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produto_repository.deleteById(id);
	}
}
