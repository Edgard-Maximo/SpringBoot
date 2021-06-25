package helloworld.objetivosApredizagem.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class objetivosAprendizagemController {

	@RequestMapping("/helloWorld")
	public String helloWorld() {
		return " Objetivo de ter persistênsia, foco e comunicação";
}
}
