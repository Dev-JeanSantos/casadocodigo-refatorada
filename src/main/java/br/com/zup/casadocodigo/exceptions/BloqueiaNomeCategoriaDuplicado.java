package br.com.zup.casadocodigo.exceptions;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.criarCategoria.Categoria;
import br.com.zup.casadocodigo.criarCategoria.CategoriaDTO;
import br.com.zup.casadocodigo.criarCategoria.CategoriaRepository;

@Component
public class BloqueiaNomeCategoriaDuplicado implements Validator{
	
	@Autowired
	private CategoriaRepository repository;

	//MAPEIA A CLASSE QUE SERÁ VALIDADA
	@Override
	public boolean supports(Class<?> clazz) {
		
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//SE AS VALIDAÇÕES DO SPRING OCORREREM O CÓDIGO FIBALIZA AQUI!
		if(errors.hasErrors()) {
			return;
		}
		
		//O AUTORDTO É O ALVO
		CategoriaDTO categoriaDTO = (CategoriaDTO) target;
		
		Optional<Categoria> talvezCategoria = repository.findByNome(categoriaDTO.getNome());
		
		if (talvezCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe Categoria com o nome " + categoriaDTO.getNome() + " cadastrada");
		}
	}

}
