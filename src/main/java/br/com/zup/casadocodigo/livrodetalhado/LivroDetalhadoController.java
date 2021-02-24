package br.com.zup.casadocodigo.livrodetalhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.livro.Livro;

@RestController
public class LivroDetalhadoController{
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@GetMapping(value = "livros/{id}")	
	public ResponseEntity<?> detalhesLivros(@PathVariable("id") Long id) {
		
		Livro livroBuscado = manager.find(Livro.class, id);
		
		if(livroBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalhesLivroResponse detalheLivroResponse = new DetalhesLivroResponse(livroBuscado);
		return ResponseEntity.ok(detalheLivroResponse);

	}
}
