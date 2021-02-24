package br.com.zup.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid LivroEntradaDTO livroDTO) {
		
		Livro livro = livroDTO.saveAs(manager);		
		manager.persist(livro);
		return livro.toString();
	}
	
	@GetMapping
    @Transactional(readOnly = true)
    public List<LivroSaidaDTO> listar() {
        return manager.createQuery("select l from Livro l", Livro.class)
                .getResultStream().map(LivroSaidaDTO::new).collect(Collectors.toList());
    }
	
}