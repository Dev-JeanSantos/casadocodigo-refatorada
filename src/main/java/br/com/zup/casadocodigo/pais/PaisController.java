package br.com.zup.casadocodigo.pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {
	

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String salvar(@RequestBody @Valid PaisDTO paisRequest){

        Pais pais = paisRequest.toModel();
        manager.persist(pais);
        
        return pais.toString();

    }
}
