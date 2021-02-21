package br.com.zup.casadocodigo.criarAutor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutoresController {
	
	@PersistenceContext
	private EntityManager entityManger;
	
	
	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid AutorDTO dto) {		
		Autor autor = dto.convert();
		entityManger.persist(autor);
		return  autor.toString();
	}
}
