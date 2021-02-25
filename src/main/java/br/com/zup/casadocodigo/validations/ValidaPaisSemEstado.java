package br.com.zup.casadocodigo.validations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.cliente.ClienteDTO;
import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.estado.EstadoRepository;

@Component
public class ValidaPaisSemEstado implements Validator {

	@Autowired
	private EstadoRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		ClienteDTO clienteDTO = (ClienteDTO) target;

		List<Estado> estadosPais = repository.buscarTodosEstadosPorPais(clienteDTO.getIdPais());

		if (estadosPais.isEmpty()) {
			if (clienteDTO.getIdEstado() != null) {
				errors.rejectValue("idEstado", null, "Este pais não tem nenhum estado cadastrado");
			}
		} else {
			if (!clienteDTO.estadoTaNoPais(estadosPais)) {
				errors.rejectValue("idEstado", null, "Não existe esse estado nesse pais");
			}

		}
	}
}
