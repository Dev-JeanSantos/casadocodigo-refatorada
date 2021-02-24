package br.com.zup.casadocodigo.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid CategoriaEntardaDTO categoriaDTO) {
		
		Categoria categoria =  new Categoria(categoriaDTO.getNome());
		entityManager.persist(categoria);
		return categoria.toString();		

	}
	
}
