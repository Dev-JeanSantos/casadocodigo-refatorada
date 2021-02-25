package br.com.zup.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.validations.ValidaPaisSemEstado;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	private ValidaPaisSemEstado validaPaisSemEstado;
	
	 @InitBinder
	    public void init(WebDataBinder binder) {
	        binder.addValidators(validaPaisSemEstado);
	    }

	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Cliente> criar(@RequestBody @Valid ClienteDTO clienteDTO) {		
		
		Cliente cliente = clienteDTO.saveAs(manager);
		manager.persist(cliente);
		return ResponseEntity.ok(cliente);
	}

}
