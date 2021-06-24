package br.org.generation.helloturma25.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Mentalidades de, Persistênsia, Atenção ao Detalhe e Mentalidade De Crescimento. ";
	}
}

