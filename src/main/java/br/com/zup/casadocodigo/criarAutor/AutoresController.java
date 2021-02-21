package br.com.zup.casadocodigo.criarAutor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.exceptions.BloqueiaEmailDuplicado;

@RestController
@RequestMapping("/autores")
public class AutoresController {
	
	@PersistenceContext
	private EntityManager entityManger;
	@Autowired
	private BloqueiaEmailDuplicado bloqueiaEmailDUplicado;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(bloqueiaEmailDUplicado);
	}
	
	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid AutorDTO dto) {		
		Autor autor = dto.convert();
		entityManger.persist(autor);
		return  autor.toString();
	}
}
