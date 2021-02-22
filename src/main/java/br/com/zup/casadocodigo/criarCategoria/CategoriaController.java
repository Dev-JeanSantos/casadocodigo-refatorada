package br.com.zup.casadocodigo.criarCategoria;

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

import br.com.zup.casadocodigo.exceptions.BloqueiaNomeCategoriaDuplicado;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private BloqueiaNomeCategoriaDuplicado bloqueiaNomeCategoriaDuplicado;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(bloqueiaNomeCategoriaDuplicado);
	}
	
	
	
	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid CategoriaDTO categoriaDTO) {
		
		Categoria categoria =  new Categoria(categoriaDTO.getNome());
		entityManager.persist(categoria);
		return categoria.toString();		

	}
	
}
