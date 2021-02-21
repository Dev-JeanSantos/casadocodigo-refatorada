package br.com.zup.casadocodigo.exceptions;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.criarAutor.Autor;
import br.com.zup.casadocodigo.criarAutor.AutorDTO;
import br.com.zup.casadocodigo.criarAutor.AutorRepository;

@Component
public class BloqueiaEmailDuplicado implements Validator{
	
	@Autowired
	private AutorRepository repository;

	//MAPEIA A CLASSE QUE SERÁ VALIDADA
	@Override
	public boolean supports(Class<?> clazz) {
		
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//SE AS VALIDAÇÕES DO SPRING OCORREREM O CÓDIGO FIBALIZA AQUI!
		if(errors.hasErrors()) {
			return;
		}
		
		//O AUTORDTO É O ALVO
		AutorDTO autorDTO = (AutorDTO) target;
		
		Optional<Autor> talvezAutor = repository.findByEmail(autorDTO.getEmail());
		
		if (talvezAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe Autor(a) com o email " + autorDTO.getEmail() + " cadastrado");
		}
	}

}
